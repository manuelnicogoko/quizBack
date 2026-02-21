package com.example.proyectoquiz.services.pregunta;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PreguntaDTO;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    private final QuizRepository quizRepository;

    private final UsuarioRepository usuarioRepository;

    public List<Pregunta> getPreguntasByQuizId(Long quizId) {
        return preguntaRepository.findByQuizId(quizId);
    }

    public Pregunta getPreguntaById(Long id) throws RuntimeException {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
    }

    public Pregunta getPreguntaByPosicion(Long quizId, Integer posicion) throws RuntimeException {
        return preguntaRepository.findByQuizIdAndPosicion(quizId, posicion);
    }

    public Pregunta savePregunta(Long quizId, PreguntaDTO preguntaDTO) throws RuntimeException {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        Pregunta pregunta = new Pregunta();

        pregunta.setEnunciado(preguntaDTO.getEnunciado());
        pregunta.setImagen(preguntaDTO.getImagen());
        pregunta.setPosicion(preguntaDTO.getPosicion());
        pregunta.setPistas(preguntaDTO.getPistas());
        pregunta.setRespuestas(preguntaDTO.getRespuestas());
        pregunta.setQuiz(quiz);

        return preguntaRepository.save(pregunta);
    }

    public void deletePregunta(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        Quiz quiz = preguntaRepository.findQuizByPreguntaId(id);

        if (usuario.getRol() != Rol.ADMIN && quiz.getCreador().getId() != usuario.getId()) {
            throw new RuntimeException("No tienes permisos para eliminar esta pregunta");
        }

        preguntaRepository.deleteById(id);
    }
}
