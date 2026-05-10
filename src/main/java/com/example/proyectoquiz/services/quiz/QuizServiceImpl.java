package com.example.proyectoquiz.services.quiz;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.config.PropiedadesApp;
import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Notificacion;
import com.example.proyectoquiz.domain.Pista;
import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PreguntaDTO;
import com.example.proyectoquiz.dto.QuizAdminDTO;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PropiedadAppException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.CategoriaRepository;
import com.example.proyectoquiz.repository.PistaRepository;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.RespuestaRepository;
import com.example.proyectoquiz.repository.SubcategoriaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.services.notificaciones.NotificacionService;
import com.example.proyectoquiz.services.websocket.WebSocketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final PreguntaRepository preguntaRepository;

    private final PistaRepository pistaRepository;

    private final RespuestaRepository respuestaRepository;

    private final CategoriaRepository categoriaRepository;

    private final SubcategoriaRepository subcategoriaRepository;

    private final UsuarioRepository usuarioRepository;

    private final NotificacionService notificacionService;

    private final WebSocketService webSocketService;

    private final PropiedadesApp propiedadesApp;

    private final Integer PAGE_SIZE_DEFAULT = 9;

    public Page<Quiz> getAllQuizzes(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findByEstado(Estado.ACEPTADO, pageable);
    }

    public Page<Quiz> getQuizzesByCategoriaId(Long categoriaId, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findByCategoriaIdAndEstado(categoriaId, Estado.ACEPTADO, pageable);
    }

    public Page<Quiz> getQuizzesBySubcategoriaId(Long subcategoriaId, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findBySubcategoriaIdAndEstado(subcategoriaId, Estado.ACEPTADO, pageable);
    }

    public Page<Quiz> getQuizzesByNombre(String nombre, Integer pageNumber) throws RuntimeException {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findByNombreContainingIgnoreCaseAndEstado(nombre, Estado.ACEPTADO, pageable);
    }

    public Quiz getQuizById(Long id) throws RuntimeException {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
    }

    public Quiz saveQuiz(QuizDTO quizDTO)
            throws RuntimeException, UserNotFoundException, AuthException, PropiedadAppException {
        if (quizRepository.count() >= propiedadesApp.getMaxQuizzesCreados()) {
            throw new PropiedadAppException(
                    "No se pueden crear más quizzes. Límite alcanzado: " + propiedadesApp.getMaxQuizzesCreados());
        }
        if (quizDTO.getPreguntas().size() > propiedadesApp.getMaxPreguntas()) {
            throw new PropiedadAppException(
                    "Un quiz no puede tener más de " + propiedadesApp.getMaxPreguntas() + " preguntas.");
        }
        if (quizDTO.getPreguntas().size() < propiedadesApp.getMinPreguntas()) {
            throw new PropiedadAppException(
                    "Un quiz debe tener al menos " + propiedadesApp.getMinPreguntas() + " preguntas.");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        Quiz quiz = new Quiz();
        quiz.setCreador(usuario);
        quiz.setNombre(quizDTO.getNombre());
        quiz.setDescripcion(quizDTO.getDescripcion());
        quiz.setEstado(Estado.PENDIENTE);
        quiz.setPortada(quizDTO.getPortada());

        Categoria categoria = categoriaRepository.findById(quizDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        quiz.setCategoria(categoria);

        Subcategoria subcategoria = subcategoriaRepository.findById(quizDTO.getSubcategoriaId())
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));

        quiz.setSubcategoria(subcategoria);

        Quiz quizDevuelto = quizRepository.save(quiz);

        if (quizDTO.getPreguntas() != null) {
            for (PreguntaDTO preguntaDTO : quizDTO.getPreguntas()) {
                Pregunta pregunta = new Pregunta();
                pregunta.setEnunciado(preguntaDTO.getEnunciado());
                pregunta.setPosicion(preguntaDTO.getPosicion());
                pregunta.setQuiz(quiz);
                Pregunta preguntaGuardada = preguntaRepository.save(pregunta);

                if (preguntaDTO.getPistas() != null) {
                    for (String pistaTexto : preguntaDTO.getPistas()) {
                        Pista pista = new Pista();
                        pista.setTexto(pistaTexto);
                        pista.setPregunta(preguntaGuardada);
                        pistaRepository.save(pista);
                    }
                }

                if (preguntaDTO.getRespuestas() != null) {
                    for (String respuestaTexto : preguntaDTO.getRespuestas()) {
                        Respuesta respuesta = new Respuesta();
                        respuesta.setTexto(respuestaTexto);
                        respuesta.setPregunta(preguntaGuardada);
                        respuestaRepository.save(respuesta);
                    }
                }
            }
        }

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje("Quiz: " + quizDevuelto.getNombre());
        notificacion.setTipo("NUEVO_QUIZ");
        notificacion.setLeida(false);
        notificacion.setFecha(LocalDateTime.now());
        notificacion.setQuizId(quizDevuelto.getId());
        notificacion.setDestinatario(null);

        notificacionService.crearYNotificar(notificacion, null, webSocketService);

        return quizDevuelto;
    }

    public void deleteQuiz(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar este quiz");
        }

        quizRepository.deleteById(id);
    }

    public Quiz updateQuiz(Long id, QuizAdminDTO quizDTO)
            throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para actualizar este quiz");
        }

        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        quiz.setNombre(quizDTO.getNombre());
        quiz.setDescripcion(quizDTO.getDescripcion());
        quiz.setEstado(Estado.valueOf(quizDTO.getEstado()));

        Categoria categoria = categoriaRepository.findById(quizDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        quiz.setCategoria(categoria);

        Subcategoria subcategoria = subcategoriaRepository.findById(quizDTO.getSubcategoriaId())
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));

        quiz.setSubcategoria(subcategoria);

        Quiz quizDevuelto = quizRepository.save(quiz);

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(
                "Quiz: " + quizDevuelto.getNombre());
        notificacion.setTipo("ESTADO_QUIZ");
        notificacion.setLeida(false);
        notificacion.setFecha(LocalDateTime.now());
        notificacion.setQuizId(quizDevuelto.getId());
        notificacion.setDestinatario(quizDevuelto.getCreador());

        notificacionService.crearYNotificar(notificacion, quizDevuelto.getCreador().getId(), webSocketService);

        return quizDevuelto;
    }

    public Quiz updateQuizPortada(Long id, String nuevaPortada) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
        quiz.setPortada(nuevaPortada);
        return quizRepository.save(quiz);
    }

    public Page<Quiz> getQuizzesByUsuario(Long creadorId, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findByCreadorId(creadorId, pageable);
    }

    public Page<Quiz> getQuizzesPendientes(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE_DEFAULT);
        return quizRepository.findByEstado(Estado.PENDIENTE, pageable);
    }
}
