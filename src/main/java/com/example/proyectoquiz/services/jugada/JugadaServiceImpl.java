package com.example.proyectoquiz.services.jugada;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Jugada;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Ronda;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.JugadaDTO;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.JugadaRepository;
import com.example.proyectoquiz.repository.PartidaRepository;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.RondaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadaServiceImpl implements JugadaService {

    private static final Double PUNTUACION_CORRECTA = 10.0;

    private final JugadaRepository jugadaRepository;

    private final UsuarioRepository usuarioRepository;

    private final PartidaRepository partidaRepository;

    private final RondaRepository rondaRepository;

    private final PreguntaRepository preguntaRepository;

    public List<Jugada> getJugadasPartidaRonda(String codPartida, Integer numeroRonda) {
        return jugadaRepository.findByPartidaCodigoAndRondaNumeroRonda(codPartida, numeroRonda);
    }

    public Jugada saveJugada(String codPartida, Integer numeroRonda, JugadaDTO jugadaDTO)
            throws RuntimeException, UserNotFoundException, PartidaNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        Partida partida = partidaRepository.findByCodigo(codPartida);

        if (partida == null) {
            throw new PartidaNotFoundException(codPartida);
        }

        Quiz quiz = partida.getQuiz();

        Pregunta pregunta = preguntaRepository.findByQuizIdAndPosicion(quiz.getId(), numeroRonda);
        if (pregunta == null) {
            throw new RuntimeException("Pregunta no encontrada");
        }

        Ronda ronda = rondaRepository.findByPartidaAndNumeroRonda(partida.getId(), numeroRonda);
        if (ronda == null) {
            throw new RuntimeException("Ronda no encontrada");
        }

        Jugada jugada = new Jugada();

        String respuesta = jugadaDTO.getRespuesta();
        if (pregunta.getRespuestas().contains(respuesta)) {
            jugada.setRespuesta(respuesta);
            jugada.setCorrecta(true);
            jugada.setPuntuacion(PUNTUACION_CORRECTA);
            jugada.setTiempoRespuesta(jugadaDTO.getTiempoRespuesta());
            jugada.setPartida(partida);
            jugada.setRonda(ronda);
            jugada.setUsuario(usuario);
            usuario.setPuntuacionTotal(usuario.getPuntuacionTotal() + PUNTUACION_CORRECTA);
        } else {
            jugada.setRespuesta(respuesta);
            jugada.setCorrecta(false);
            jugada.setPuntuacion(0.00);
            jugada.setTiempoRespuesta(jugadaDTO.getTiempoRespuesta());
            jugada.setPartida(partida);
            jugada.setRonda(ronda);
            jugada.setUsuario(usuario);
        }

        return jugadaRepository.save(jugada);
    }

}
