package com.example.proyectoquiz.services.inscripcion;

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
import com.example.proyectoquiz.utils.GenerarCodigoPartida;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InscripcionServiceImpl implements InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    private final UsuarioRepository usuarioRepository;

    private final PartidaRepository partidaRepository;

    private final GenerarCodigoPartida generarCodigoPartida;

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

        Partida partida = partidaRepository.findByCodigo(inscripcionDTO.getCodigoPartida());
        if (partida == null) {
            throw new RuntimeException("Partida no encontrada");
        }

        Inscripcion inscripcion = new Inscripcion();

        String codigoInscripcion = generarCodigoPartida.generarCodigoAleatorio();

        if (partida.getCodigoAnfitrion() == null || partida.getCodigoAnfitrion().isEmpty()) {
            partida.setCodigoAnfitrion(codigoInscripcion);
            partidaRepository.save(partida);
        }

        if (authentication == null || "anonymousUser".equals(authentication.getName())) {
            if (inscripcionDTO.getNombre() == null || inscripcionDTO.getNombre().isEmpty()) {
                throw new RuntimeException("El nombre es obligatorio");
            }
            if (inscripcionRepository.existsByPartidaAndNombre(partida, inscripcionDTO.getNombre())) {
                throw new RuntimeException("Ese nombre ya está en uso en esta partida");
            }
            inscripcion.setNombre(inscripcionDTO.getNombre());
            inscripcion.setUsuario(null);
        } else {
            String email = authentication.getName();
            Usuario usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) {
                throw new UserNotFoundException(email);
            }
            inscripcion.setNombre(inscripcionDTO.getNombre());
            inscripcion.setUsuario(usuario);
        }

        inscripcion.setCodigoInscripcion(codigoInscripcion);
        inscripcion.setPuntuacionTotalPartida(0.0);
        inscripcion.setPartida(partida);

        Integer numJugadores = partida.getNumeroJugadores();
        if (numJugadores == null) {
            numJugadores = 0;
        }

        partida.setNumeroJugadores(numJugadores + 1);
        partidaRepository.save(partida);
        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcionPorCodigo(String codigoInscripcion) throws RuntimeException {
        Inscripcion inscripcion = inscripcionRepository.findByCodigoInscripcion(codigoInscripcion);

        if (inscripcion != null) {
            Partida partida = inscripcion.getPartida();
            inscripcionRepository.delete(inscripcion);

            if (partida != null && partida.getNumeroJugadores() != null && partida.getNumeroJugadores() > 0) {
                partida.setNumeroJugadores(partida.getNumeroJugadores() - 1);
                partidaRepository.save(partida);
            }
        }
    }
}
