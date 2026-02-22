package com.example.proyectoquiz.services.pista;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Pista;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.PistaRepository;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PistaServiceImpl implements PistaService {

    private final PistaRepository pistaRepository;

    private final PreguntaRepository preguntaRepository;

    private final UsuarioRepository usuarioRepository;

    public List<Pista> getPistasByPreguntaId(Long preguntaId) {
        return pistaRepository.findByPreguntaId(preguntaId);
    }

    public Pista getPistaById(Long id) throws RuntimeException {
        return pistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pista no encontrada"));
    }

    public Pista savePista(Pista pista) {
        return pistaRepository.save(pista);
    }

    public void deletePista(Long id) throws RuntimeException, UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        if (usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("No tienes permisos para eliminar esta pista");
        }

        pistaRepository.deleteById(id);
    }

}
