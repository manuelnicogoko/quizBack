package com.example.proyectoquiz.services.jugada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.domain.Jugada;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Ronda;
import com.example.proyectoquiz.dto.JugadaDTO;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.repository.InscripcionRepository;
import com.example.proyectoquiz.repository.JugadaRepository;
import com.example.proyectoquiz.repository.PartidaRepository;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.RondaRepository;

import com.example.proyectoquiz.repository.RespuestaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadaServiceImpl implements JugadaService {

    private static final double PUNTUACION_MAXIMA = 100.0;
    private static final double TIEMPO_GRACIA = 5.0;
    private static final double PENALIZACION_TIEMPO = 0.10;
    private static final double PENALIZACION_FALLO = 0.20;

    private final JugadaRepository jugadaRepository;

    private final PartidaRepository partidaRepository;

    private final RondaRepository rondaRepository;

    private final PreguntaRepository preguntaRepository;

    private final RespuestaRepository respuestaRepository;

    private final InscripcionRepository inscripcionRepository;

    public List<Jugada> getJugadasPartidaRonda(String codPartida, Integer numeroRonda) {
        return jugadaRepository.findByPartidaCodigoAndRondaNumeroRonda(codPartida, numeroRonda);
    }

    public Jugada saveJugada(String codPartida, Integer numeroRonda, JugadaDTO jugadaDTO)
            throws RuntimeException, PartidaNotFoundException {
        Partida partida = partidaRepository.findByCodigo(codPartida);
        if (partida == null) {
            throw new PartidaNotFoundException(codPartida);
        }
        int maxFallos = partida.getVidas();
        double maxTiempoRespuesta = partida.getTiempoRonda();

        Quiz quiz = partida.getQuiz();
        Pregunta pregunta = preguntaRepository.findByQuizIdAndPosicion(quiz.getId(), numeroRonda);
        if (pregunta == null) {
            throw new RuntimeException("Pregunta no encontrada");
        }

        Ronda ronda = rondaRepository.findByPartidaIdAndNumeroRonda(partida.getId(), numeroRonda);
        if (ronda == null) {
            throw new RuntimeException("Ronda no encontrada");
        }

        Jugada jugada = new Jugada();
        List<Respuesta> respuestas = respuestaRepository.findByPreguntaId(pregunta.getId());
        List<String> opcionesCorrectas = new ArrayList<>();
        for (Respuesta respuesta : respuestas) {
            opcionesCorrectas.add(respuesta.getTexto());
        }

        String codigoInscripcion = jugadaDTO.getCodigoInscripcion();
        if (codigoInscripcion == null || codigoInscripcion.isEmpty()) {
            throw new RuntimeException("Código de Inscripción requerido");
        }
        Inscripcion inscripcion = inscripcionRepository.findByCodigoInscripcionAndPartidaId(codigoInscripcion,
                partida.getId());
        if (inscripcion == null) {
            throw new RuntimeException("Inscripción no encontrada");
        }

        String respuesta = jugadaDTO.getRespuesta();
        boolean esCorrecta = opcionesCorrectas.contains(respuesta);

        Long fallosPrevios = jugadaRepository.countByInscripcionIdAndRondaIdAndCorrectaFalse(
                inscripcion.getId(), ronda.getId());

        double tiempoRespuesta = jugadaDTO.getTiempoRespuesta() != null ? jugadaDTO.getTiempoRespuesta() : 0.0;

        double puntuacion = PUNTUACION_MAXIMA;

        if (esCorrecta) {
            puntuacion -= PUNTUACION_MAXIMA * PENALIZACION_FALLO * fallosPrevios;

            if (tiempoRespuesta > TIEMPO_GRACIA) {
                double segundosExtra = tiempoRespuesta - TIEMPO_GRACIA;
                int tramos = (int) Math.ceil(segundosExtra / 5.0);
                puntuacion -= PUNTUACION_MAXIMA * PENALIZACION_TIEMPO * tramos;
            }

            if (fallosPrevios >= maxFallos || tiempoRespuesta >= maxTiempoRespuesta) {
                puntuacion = 0.0;
            }

            if (puntuacion < 0)
                puntuacion = 0.0;
            if (puntuacion > PUNTUACION_MAXIMA)
                puntuacion = PUNTUACION_MAXIMA;

            jugada.setRespuesta(respuesta);
            jugada.setCorrecta(true);
            jugada.setPuntuacion(puntuacion);
            inscripcion.setPuntuacionTotalPartida(inscripcion.getPuntuacionTotalPartida() + puntuacion);
        } else {
            jugada.setRespuesta(respuesta);
            jugada.setCorrecta(false);
            jugada.setPuntuacion(0.00);
        }

        jugada.setTiempoRespuesta(tiempoRespuesta);
        jugada.setPartida(partida);
        jugada.setRonda(ronda);
        jugada.setInscripcion(inscripcion);
        inscripcionRepository.save(inscripcion);

        return jugadaRepository.save(jugada);
    }

}
