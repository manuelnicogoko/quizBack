package com.example.proyectoquiz.services.usuario;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.config.PropiedadesApp;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.dto.UsuarioDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PropiedadAppException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.security.JwtUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final PasswordEncoder passwordEncoder;

    private final UsuarioRepository usuarioRepository;

    private final JwtUtils jwtUtils;

    private final PropiedadesApp propiedadesApp;

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

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (usuario == null) {
            throw new UserNotFoundException(usuario.getEmail());
        }

        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Usuario> usuariosConMismoNombre = usuarioRepository
                .findByNombreContainingIgnoreCase(usuarioDTO.getNombre());
        String usuarioNombre = usuarioDTO.getNombre() != null ? usuarioDTO.getNombre() : existingUsuario.getNombre();
        if (usuariosConMismoNombre != null && !usuariosConMismoNombre.isEmpty()
                && !usuariosConMismoNombre.get(0).getId().equals(id)) {
            throw new RuntimeException("El nombre ya está registrado");
        }

        Usuario usuariosConMismoEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        String usuarioEmail = usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : existingUsuario.getEmail();
        if (usuariosConMismoEmail != null && !usuariosConMismoEmail.getId().equals(id)) {
            throw new RuntimeException("El email ya está registrado");
        }

        String usuarioPassword = usuarioDTO.getPassword() != null
                ? passwordEncoder.encode(usuarioDTO.getPassword())
                : existingUsuario.getPassword();

        Rol usuarioRol = Rol.valueOf("USER");
        if (existingUsuario.getRol() != Rol.ADMIN) {
            usuarioRol = Rol.valueOf(usuarioDTO.getRol().toUpperCase());
        } else {
            usuarioRol = existingUsuario.getRol() != null ? Rol.valueOf(usuarioDTO.getRol().toUpperCase())
                    : Rol.valueOf("USER");
        }

        String usuarioAvatar = usuarioDTO.getAvatar() != null ? usuarioDTO.getAvatar() : existingUsuario.getAvatar();

        existingUsuario.setNombre(usuarioNombre);
        existingUsuario.setEmail(usuarioEmail);
        existingUsuario.setPassword(usuarioPassword);
        existingUsuario.setRol(usuarioRol);
        existingUsuario.setAvatar(usuarioAvatar);

        return usuarioRepository.save(existingUsuario);
    }

    public Usuario saveUsuario(RegisterDTO usuarioDTO) throws RuntimeException {
        if (usuarioRepository.count() >= propiedadesApp.getMaxUsuariosCreados()) {
            throw new PropiedadAppException(
                    "No se pueden registrar más usuarios. Límite alcanzado: " + propiedadesApp.getMaxUsuariosCreados());
        }

        String nombreLimpio = Jsoup.clean(usuarioDTO.getNombre(), Safelist.basic());
        String emailLimpio = Jsoup.clean(usuarioDTO.getEmail(), Safelist.none());
        String passwordLimpio = Jsoup.clean(usuarioDTO.getPassword(), Safelist.none());

        Usuario usuario = new Usuario();

        if (usuarioRepository.findByEmail(emailLimpio) != null) {
            throw new RuntimeException("El email ya está registrado");
        }

        if (usuarioRepository.findByNombreContainingIgnoreCase(nombreLimpio) != null
                && !usuarioRepository.findByNombreContainingIgnoreCase(nombreLimpio).isEmpty()) {
            throw new RuntimeException("El nombre ya está registrado");
        }

        usuario.setNombre(nombreLimpio);
        usuario.setEmail(emailLimpio);
        usuario.setPassword(passwordEncoder.encode(passwordLimpio));
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

    public String validateUserToken(String token) throws RuntimeException {
        String tokenSinBearer = token.replace("Bearer ", "");
        boolean valid = jwtUtils.validateJwtToken(tokenSinBearer);

        String message = "";
        if (valid) {
            String email = jwtUtils.getUserNameFromJwtToken(token);
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) {
                message = "Token no válido o caducado";
            } else {
                message = "Token válido";
            }
        } else {
            message = "Token no válido o caducado";
        }
        return message;
    }
}
