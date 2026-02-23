package com.example.proyectoquiz.services.inscripcion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.InscripcionDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.InscripcionRepository;
import com.example.proyectoquiz.repository.PartidaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InscripcionServiceImpl implements InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    private final UsuarioRepository usuarioRepository;

    private final PartidaRepository partidaRepository;

    public List<Inscripcion> getInscripciones(Long partidaId) {
        return inscripcionRepository.findByPartidaId(partidaId);
    }

    public List<Inscripcion> getInscripcionesPorCodigo(String codigo) {
        return inscripcionRepository.findByPartidaCodigo(codigo);
    }

    public Inscripcion saveInscripcion(InscripcionDTO inscripcionDTO) throws RuntimeException, UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (inscripcionDTO.getNombre() == null || inscripcionDTO.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        List<Usuario> usuarios = usuarioRepository.findByNombreContainingIgnoreCase(inscripcionDTO.getNombre());
        List<String> nombresUsuarios = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            nombresUsuarios.add(usuario.getNombre());
        }

        if (nombresUsuarios.contains(inscripcionDTO.getNombre())) {
            throw new RuntimeException("El nombre ya existe, por favor elige otro");
        }

        Partida partida = partidaRepository.findByCodigo(inscripcionDTO.getCodigoPartida());
        if (partida == null) {
            throw new RuntimeException("Partida no encontrada");
        }

        Inscripcion inscripcion = new Inscripcion();

        if (authentication == null) {
            inscripcion.setNombre(inscripcionDTO.getNombre());
            inscripcion.setAnonimo(true);
            inscripcion.setUsuario(null);
            inscripcion.setPuntuacionTotalPartida(0.0);
            inscripcion.setPartida(partida);
        } else {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) {
                throw new UserNotFoundException(email);
            }
            inscripcion.setNombre(inscripcionDTO.getNombre());
            inscripcion.setAnonimo(false);
            inscripcion.setUsuario(usuario);
            inscripcion.setPuntuacionTotalPartida(0.0);
            inscripcion.setPartida(partida);
        }
        partida.setNumeroJugadores(partida.getNumeroJugadores() + 1);
        partidaRepository.save(partida);
        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcion(Long id) throws RuntimeException {
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrada"));

        inscripcionRepository.delete(inscripcion);
    }
}
