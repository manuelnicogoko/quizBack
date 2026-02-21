package com.example.proyectoquiz.services.quiz;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.services.categoria.CategoriaService;
import com.example.proyectoquiz.services.subcategoria.SubcategoriaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final CategoriaService categoriaService;

    private final SubcategoriaService subcategoriaService;

    private final UsuarioRepository usuarioRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
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

    public Quiz saveQuiz(QuizDTO quizDTO) throws RuntimeException, UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        if (usuario == null) {
            throw new UserNotFoundException(username);
        }

        Quiz quiz = new Quiz();
        quiz.setCreador(usuario);
        quiz.setNombre(quizDTO.getNombre());
        quiz.setDescripcion(quizDTO.getDescripcion());

        Categoria categoria = categoriaService.getCategoriaById(quizDTO.getCategoriaId());
        quiz.setCategoria(categoria);

        Subcategoria subcategoria = subcategoriaService.getSubcategoriaById(quizDTO.getSubcategoriaId());
        quiz.setSubcategoria(subcategoria);

        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) throws RuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        if (usuario.getRol() != Rol.ADMIN && !usuario.getId().equals(quiz.getCreador().getId())) {
            throw new RuntimeException("No tienes permisos para eliminar un quiz");
        }

        quizRepository.deleteById(id);
    }

}
