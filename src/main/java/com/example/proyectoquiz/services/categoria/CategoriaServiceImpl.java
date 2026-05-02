package com.example.proyectoquiz.services.categoria;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.CategoriaAdminDTO;
import com.example.proyectoquiz.dto.CategoriaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.CategoriaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final UsuarioRepository usuarioRepository;

    private final QuizRepository quizRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findByEstado(Estado.ACEPTADO);
    }

    public List<Categoria> getAllCategoriasEditar() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) throws RuntimeException {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    public Categoria saveCategoria(CategoriaDTO categoriaDTO)
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

        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setEstado(Estado.PENDIENTE);
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, CategoriaAdminDTO categoriaDTO)
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
            throw new RuntimeException("No tienes permisos para actualizar esta categoria");
        }

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoria.setLogo(categoriaDTO.getLogo());
        categoria.setEstado(Estado.ACEPTADO);
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar esta categoria");
        }

        List<Quiz> quizzes = quizRepository.findByCategoriaId(id);

        if (!quizzes.isEmpty()) {
            Categoria categoriaOtros = categoriaRepository.findByNombre("Otros");

            for (Quiz quiz : quizzes) {
                quiz.setCategoria(categoriaOtros);
                quizRepository.save(quiz);
            }
        }

        categoriaRepository.deleteById(id);
    }

}
