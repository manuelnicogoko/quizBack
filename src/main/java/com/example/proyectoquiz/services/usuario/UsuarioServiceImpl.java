package com.example.proyectoquiz.services.usuario;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.dto.UsuarioDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final PasswordEncoder passwordEncoder;

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) throws RuntimeException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario updateUsuario(Long id, UsuarioDTO usuarioDTO)
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

        if (usuario.getRol() != Rol.ADMIN && !usuario.getId().equals(id)) {
            throw new RuntimeException("No tienes permisos para actualizar este usuario");
        }

        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existingUsuario.setNombre(usuarioDTO.getNombre());
        existingUsuario.setEmail(usuarioDTO.getEmail());
        existingUsuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        return usuarioRepository.save(existingUsuario);
    }

    public Usuario saveUsuario(RegisterDTO usuarioDTO) throws RuntimeException {
        Usuario usuario = new Usuario();

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new RuntimeException("El email ya está registrado");
        }

        if (usuarioRepository.findByNombreContainingIgnoreCase(usuarioDTO.getNombre()) != null
                && !usuarioRepository.findByNombreContainingIgnoreCase(usuarioDTO.getNombre()).isEmpty()) {
            throw new RuntimeException("El nombre ya está registrado");
        }

        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        usuario.setAvatar(usuarioDTO.getAvatar());
        usuario.setRol(Rol.valueOf(usuarioDTO.getRol().toUpperCase()));

        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) throws RuntimeException, UserNotFoundException, AuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        if (usuario.getRol() != Rol.ADMIN && !usuario.getId().equals(id)) {
            throw new RuntimeException("No tienes permisos para actualizar este usuario");
        }
        usuarioRepository.deleteById(id);
    }
}
