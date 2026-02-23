package com.example.proyectoquiz.services.ronda;

import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Ronda;
import com.example.proyectoquiz.dto.RondaDTO;
import com.example.proyectoquiz.repository.PartidaRepository;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.RondaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RondaServiceImpl implements RondaService {
    private final RondaRepository rondaRepository;

    private final PartidaRepository partidaRepository;

    private final PreguntaRepository preguntaRepository;

    public Ronda getRondaById(Long id) throws RuntimeException {
        return rondaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ronda no encontrada"));
    }

    public Ronda saveRonda(String codPartida, RondaDTO rondaDTO) throws RuntimeException {
        Partida partida = partidaRepository.findByCodigo(codPartida);

        if (partida == null) {
            throw new RuntimeException("Partida no encontrada");
        }

        Quiz quiz = partida.getQuiz();

        Pregunta pregunta = preguntaRepository.findByQuizIdAndPosicion(quiz.getId(), rondaDTO.getNumeroRonda());

        if (pregunta == null) {
            throw new RuntimeException("Pregunta no encontrada");
        }

        Ronda ronda = new Ronda();

        ronda.setNumeroRonda(rondaDTO.getNumeroRonda());
        ronda.setEstado(Estado.EN_CURSO);
        ronda.setPartida(partida);
        ronda.setPregunta(pregunta);

        return rondaRepository.save(ronda);
    }

    public void deleteRonda(Long id) {
        rondaRepository.deleteById(id);
    }

    public Ronda finalizarRonda(String codPartida, Integer numeroRonda) throws RuntimeException {
        Partida partida = partidaRepository.findByCodigo(codPartida);
        Ronda ronda = rondaRepository.findByPartidaIdAndNumeroRonda(partida.getId(), numeroRonda);

        ronda.setEstado(Estado.FINALIZADA);

        return rondaRepository.save(ronda);
    }
}
