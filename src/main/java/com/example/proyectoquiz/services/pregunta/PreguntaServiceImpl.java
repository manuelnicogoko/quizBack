package com.example.proyectoquiz.services.pregunta;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PreguntaActualizacionDTO;
import com.example.proyectoquiz.dto.PreguntaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.services.files.FileStorageService;
import com.example.proyectoquiz.services.pista.PistaService;
import com.example.proyectoquiz.services.respuesta.RespuestaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    private final QuizRepository quizRepository;

    private final UsuarioRepository usuarioRepository;

    private final PistaService pistaService;

    private final RespuestaService respuestaService;

    // private final FileStorageService fileStorageService;

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

        pregunta.setPosicion(preguntaDTO.getPosicion());
        pregunta.setQuiz(quiz);

        return preguntaRepository.save(pregunta);
    }

    public Pregunta updatePregunta(Long id, PreguntaActualizacionDTO preguntaDTO) throws RuntimeException {
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

        if (preguntaDTO.getEnunciado() != null && !preguntaDTO.getEnunciado().trim().isEmpty()) {
            pregunta.setEnunciado(Jsoup.clean(preguntaDTO.getEnunciado(), Safelist.basic()));
        }
        if (preguntaDTO.getImagen() != null && !preguntaDTO.getImagen().trim().isEmpty()) {
            pregunta.setImagen(preguntaDTO.getImagen());
        }
        if (preguntaDTO.getPosicion() != null && preguntaDTO.getPosicion() > 0) {
            pregunta.setPosicion(preguntaDTO.getPosicion());
        }
        if (preguntaDTO.getPistas() != null && !preguntaDTO.getPistas().isEmpty()) {
            pistaService.actualizarPistasDePregunta(id, preguntaDTO.getPistas());
        }
        if (preguntaDTO.getRespuestas() != null && !preguntaDTO.getRespuestas().isEmpty()) {
            respuestaService.actualizarRespuestasDePregunta(id, preguntaDTO.getRespuestas());
        }

        return preguntaRepository.save(pregunta);
    }

    public void deletePregunta(Long id) throws RuntimeException, UserNotFoundException, AuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        if (usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("No tienes permisos para eliminar esta pregunta");
        }

        preguntaRepository.deleteById(id);
    }

}
