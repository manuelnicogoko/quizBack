package com.example.proyectoquiz.services.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.CategoriaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.SubcategoriaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.services.correo.CorreoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final CategoriaRepository categoriaRepository;

    private final SubcategoriaRepository subcategoriaRepository;

    private final UsuarioRepository usuarioRepository;

    private final CorreoService correoService;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    @Value("${spring.mail.username}")
    private String adminEmail;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findByEstado(Estado.ACEPTADO);
    }

    public List<Quiz> getQuizzesByCategoriaId(Long categoriaId) {
        return quizRepository.findByCategoriaId(categoriaId);
    }

    public List<Quiz> getQuizzesBySubcategoriaId(Long subcategoriaId) {
        return quizRepository.findBySubcategoriaId(subcategoriaId);
    }

    public List<Quiz> getQuizzesByNombre(String nombre) throws RuntimeException {
        return quizRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Quiz getQuizById(Long id) throws RuntimeException {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
    }

    public Quiz saveQuiz(QuizDTO quizDTO) throws RuntimeException, UserNotFoundException, AuthException {
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

        Categoria categoria = categoriaRepository.findById(quizDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        quiz.setCategoria(categoria);

        Subcategoria subcategoria = subcategoriaRepository.findById(quizDTO.getSubcategoriaId())
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));
        quiz.setSubcategoria(subcategoria);

        String enlace = frontendUrl + "/quiz/" + quiz.getId();

        String mensaje = "El usuario " + usuario.getNombre() + " ha solicitado crear el quiz " + quiz.getNombre()
                + "\n\nGestiona el quiz aquí: \n" + enlace;

        correoService.enviarEmail(adminEmail, "Nuevo Quiz Pendiente", mensaje);

        return quizRepository.save(quiz);
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

    public Quiz updateQuiz(Long id, QuizDTO quizDTO) throws RuntimeException, UserNotFoundException, AuthException {
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
        quiz.setEstado(Estado.ACEPTADO);

        Categoria categoria = categoriaRepository.findById(quizDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        quiz.setCategoria(categoria);

        Subcategoria subcategoria = subcategoriaRepository.findById(quizDTO.getSubcategoriaId())
                .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));

        quiz.setSubcategoria(subcategoria);

        return quizRepository.save(quiz);
    }

}
