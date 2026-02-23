package com.example.proyectoquiz.services.partida;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PartidaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.InscripcionRepository;
import com.example.proyectoquiz.repository.PartidaRepository;
import com.example.proyectoquiz.repository.QuizRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.utils.GenerarCodigoPartida;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;

    private final UsuarioRepository usuarioRepository;

    private final QuizRepository quizRepository;

    private final GenerarCodigoPartida generarCodigoPartida;

    private final InscripcionRepository inscripcionRepository;

    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    public List<Partida> getPartidasPublicas() {
        return partidaRepository.findByPublicaTrue();
    }

    public Partida getPartidaByCodigo(String codigo) throws RuntimeException {
        Partida partida = partidaRepository.findByCodigo(codigo);
        if (partida == null) {
            throw new PartidaNotFoundException(codigo);
        }
        return partida;
    }

    public Partida savePartida(PartidaDTO partidaDTO) throws RuntimeException, UserNotFoundException, AuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        Quiz quiz = quizRepository.findById(partidaDTO.getQuiz())
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        String codigo = generarCodigoPartida.generarCodigoAleatorio();
        String codigoSocket = generarCodigoPartida.generarCodigoAleatorio();

        Partida partida = new Partida();
        partida.setNombre(partidaDTO.getNombre());
        partida.setMaxJugadores(partidaDTO.getMaxJugadores());
        partida.setPublica(partidaDTO.getPublica());
        partida.setVidas(partidaDTO.getVidas());
        partida.setTiempoRonda(partidaDTO.getTiempoRonda());
        partida.setFechaCreacion(LocalDate.now());
        partida.setEstado(Estado.EN_CURSO);
        partida.setUsuario(usuario);
        partida.setCodigo(codigo);
        partida.setCodigoSocket(codigoSocket);
        partida.setQuiz(quiz);

        return partidaRepository.save(partida);
    }

    public void deletePartida(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar esta partida");
        }

        partidaRepository.deleteById(id);
    }

    public Partida softDeletePartida(Long id) throws RuntimeException, UserNotFoundException, AuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        Partida partida = partidaRepository.findById(id).orElseThrow(() -> new PartidaNotFoundException(id.toString()));

        if (partida.getUsuario().getId() != usuario.getId()) {
            throw new RuntimeException("No tienes permisos para eliminar esta partida");
        }

        partida.setEstado(Estado.CANCELADA);
        return partidaRepository.save(partida);
    }

    public Partida finalizarPartida(String codigo) throws RuntimeException, UserNotFoundException, AuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthException();
        }

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UserNotFoundException(email);
        }

        Partida partida = partidaRepository.findByCodigo(codigo);

        if (partida == null) {
            throw new PartidaNotFoundException(codigo);
        }

        Inscripcion inscripcion = inscripcionRepository.findByUsuarioIdAndPartidaId(usuario.getId(), partida.getId());

        if (inscripcion == null) {
            throw new RuntimeException("Inscripcion no encontrada");
        }

        usuario.setPuntuacionTotal(usuario.getPuntuacionTotal() + inscripcion.getPuntuacionTotalPartida());
        partida.setEstado(Estado.FINALIZADA);
        return partidaRepository.save(partida);
    }
}
