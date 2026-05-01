package com.example.proyectoquiz.services.subcategoria;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.SubcategoriaAdminDTO;
import com.example.proyectoquiz.dto.SubcategoriaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.CategoriaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.SubcategoriaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubcategoriaServiceImpl implements SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;

    private final CategoriaRepository categoriaRepository;

    private final UsuarioRepository usuarioRepository;

    private final QuizRepository quizRepository;

    public List<Subcategoria> getAllSubcategorias() {
        return subcategoriaRepository.findByEstado(Estado.ACEPTADO);
    }

    public List<Subcategoria> getAllSubcategoriasEditar() {
        return subcategoriaRepository.findAll();
    }

    public Subcategoria getSubcategoriaById(Long id) throws RuntimeException {
        return subcategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategoria no encontrada"));
    }

    public Subcategoria saveSubcategoria(SubcategoriaDTO subcategoriaDTO) throws RuntimeException {
        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setNombre(subcategoriaDTO.getNombre());
        subcategoria.setDescripcion(subcategoriaDTO.getDescripcion());
        subcategoria.setEstado(Estado.PENDIENTE);

        Categoria categoria = categoriaRepository.findById(subcategoriaDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        subcategoria.setCategoria(categoria);

        return subcategoriaRepository.save(subcategoria);
    }

    public Subcategoria updateSubcategoria(Long id, SubcategoriaAdminDTO subcategoriaDTO)
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
            throw new RuntimeException("No tienes permisos para actualizar esta subcategoria");
        }

        Subcategoria subcategoria = subcategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategoria no encontrada"));

        subcategoria.setLogo(subcategoriaDTO.getLogo());
        subcategoria.setEstado(Estado.ACEPTADO);

        return subcategoriaRepository.save(subcategoria);
    }

    public void deleteSubcategoria(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar esta subcategoria");
        }

        List<Quiz> quizzes = quizRepository.findBySubcategoriaId(id);

        if (!quizzes.isEmpty()) {
            Subcategoria subcategoriaOtros = subcategoriaRepository.findByNombre("Otros");

            for (Quiz quiz : quizzes) {
                quiz.setSubcategoria(subcategoriaOtros);
                quizRepository.save(quiz);
            }
        }

        subcategoriaRepository.deleteById(id);
    }
}