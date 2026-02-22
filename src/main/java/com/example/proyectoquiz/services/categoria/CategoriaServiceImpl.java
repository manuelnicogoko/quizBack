package com.example.proyectoquiz.services.categoria;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.CategoriaDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.CategoriaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final UsuarioRepository usuarioRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) throws RuntimeException {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    public Categoria saveCategoria(CategoriaDTO categoriaDTO) throws RuntimeException, UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        if (usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("No tienes permisos para crear una categoria");
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setLogo(categoriaDTO.getLogo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, CategoriaDTO categoriaDTO) throws RuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        if (usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("No tienes permisos para actualizar esta categoria");
        }

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setLogo(categoriaDTO.getLogo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        if (usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("No tienes permisos para eliminar esta categoria");
        }

        categoriaRepository.deleteById(id);
    }

}
