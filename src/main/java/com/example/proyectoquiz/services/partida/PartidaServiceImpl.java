package com.example.proyectoquiz.services.partida;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.config.PropiedadesApp;
import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PartidaDTO;
import com.example.proyectoquiz.dto.PartidaListadoDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.exceptions.PropiedadAppException;
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

    private final PropiedadesApp propiedadesApp;

    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    public List<PartidaListadoDTO> getPartidasPublicas() {
        List<Partida> partidas = partidaRepository.findByPublicaTrue();
        List<PartidaListadoDTO> listadoPartidas = new ArrayList<>();

        for (Partida partida : partidas) {
            PartidaListadoDTO partidaDTO = new PartidaListadoDTO();
            partidaDTO.setId(partida.getId());
            partidaDTO.setNombre(partida.getNombre());
            partidaDTO.setMaxJugadores(partida.getMaxJugadores());
            partidaDTO.setNumeroJugadores(partida.getNumeroJugadores());
            if (partida.getQuiz() != null) {
                partidaDTO.setQuiz(partida.getQuiz().getNombre());
            }
            partidaDTO.setCodigo(partida.getCodigo());
            partidaDTO.setCodigoSocket(partida.getCodigoSocket());
            partidaDTO.setTiempoRonda(partida.getTiempoRonda());
            partidaDTO.setVidas(partida.getVidas());
            partidaDTO.setPublica(partida.getPublica());
            partidaDTO.setQuizId(partida.getQuiz().getId());

            listadoPartidas.add(partidaDTO);
        }

        return listadoPartidas;
    }

    public PartidaListadoDTO getPartidaByCodigo(String codigo) throws RuntimeException {
        Partida partida = partidaRepository.findByCodigo(codigo);
        if (partida == null) {
            throw new PartidaNotFoundException(codigo);
        }
        PartidaListadoDTO partidaDTO = new PartidaListadoDTO();
        partidaDTO.setId(partida.getId());
        partidaDTO.setNombre(partida.getNombre());
        partidaDTO.setMaxJugadores(partida.getMaxJugadores());
        partidaDTO.setNumeroJugadores(partida.getNumeroJugadores());
        if (partida.getQuiz() != null) {
            partidaDTO.setQuiz(partida.getQuiz().getNombre());
        }
        partidaDTO.setCodigo(partida.getCodigo());
        partidaDTO.setCodigoSocket(partida.getCodigoSocket());
        partidaDTO.setTiempoRonda(partida.getTiempoRonda());
        partidaDTO.setCodigoAnfitrion(partida.getCodigoAnfitrion());
        partidaDTO.setVidas(partida.getVidas());
        partidaDTO.setPublica(partida.getPublica());
        partidaDTO.setQuizId(partida.getQuiz().getId());
        return partidaDTO;
    }

    public Partida savePartida(PartidaDTO partidaDTO)
            throws RuntimeException, UserNotFoundException, AuthException, PropiedadAppException {
        if (partidaRepository.count() >= propiedadesApp.getMaxPartidasJugando()) {
            throw new PropiedadAppException(
                    "No se pueden crear más partidas. Límite alcanzado: " + propiedadesApp.getMaxPartidasJugando());
        }
        if (partidaDTO.getMaxJugadores() > propiedadesApp.getMaxJugadorPartida()) {
            throw new PropiedadAppException(
                    "No se pueden añadir más jugadores a la partida. Máximo: " + propiedadesApp.getMaxJugadorPartida());
        }
        if (partidaDTO.getMaxJugadores() < propiedadesApp.getMinJugadorPartida()) {
            throw new PropiedadAppException("No se pueden crear partidas con menos de "
                    + propiedadesApp.getMinJugadorPartida() + " jugadores.");
        }
        if (partidaDTO.getVidas() > propiedadesApp.getMaxVidas()
                || partidaDTO.getVidas() < propiedadesApp.getMinVidas()) {
            throw new PropiedadAppException("El número de vidas debe estar entre " + propiedadesApp.getMinVidas()
                    + " y " + propiedadesApp.getMaxVidas());
        }
        if (partidaDTO.getTiempoRonda() > propiedadesApp.getMaxTiempoRonda()
                || partidaDTO.getTiempoRonda() < propiedadesApp.getMinTiempoRonda()) {
            throw new PropiedadAppException("El tiempo de ronda debe estar entre " + propiedadesApp.getMinTiempoRonda()
                    + " y " + propiedadesApp.getMaxTiempoRonda() + " segundos.");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String nombreUsuario;
        Usuario usuario = null;

        if (authentication == null || "anonymousUser".equals(authentication.getName())) {
            nombreUsuario = partidaDTO.getNombreAnfitrion();
            // usuario = null; // explícito, pero no necesario
        } else {
            String email = authentication.getName();
            usuario = usuarioRepository.findByEmail(email);
            if (usuario == null) {
                throw new UserNotFoundException(email);
            }
            nombreUsuario = usuario.getNombre();
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
        partida.setNombreAnfitrion(nombreUsuario);
        partida.setCodigo(codigo);
        partida.setCodigoSocket(codigoSocket);
        partida.setCodigoAnfitrion(null);
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

    public Partida cancelarPartida(String codigo) throws RuntimeException, PartidaNotFoundException {
        Partida partida = partidaRepository.findByCodigo(codigo);

        if (partida != null) {
            for (Inscripcion inscripcion : inscripcionRepository.findByPartidaCodigo(codigo)) {
                if (inscripcion != null) {
                    inscripcionRepository.delete(inscripcion);
                }
            }
            partida.setEstado(Estado.CANCELADA);
            return partidaRepository.save(partida);
        } else {
            throw new PartidaNotFoundException(codigo);
        }
    }

    public Partida finalizarPartida(String codigo)
            throws RuntimeException, PartidaNotFoundException {

        Partida partida = partidaRepository.findByCodigo(codigo);
        if (partida == null) {
            throw new PartidaNotFoundException(codigo);
        }

        List<Inscripcion> inscripciones = inscripcionRepository.findByPartidaCodigo(codigo);
        if (inscripciones.isEmpty()) {
            throw new RuntimeException("Inscripcion no encontrada");
        }

        for (Inscripcion inscripcion : inscripciones) {
            Usuario usuario = inscripcion.getUsuario();
            if (usuario != null) {
                usuario.setPuntuacionTotal(usuario.getPuntuacionTotal() + inscripcion.getPuntuacionTotalPartida());
                usuarioRepository.save(usuario);
            }
        }

        partida.setEstado(Estado.FINALIZADA);
        return partidaRepository.save(partida);
    }

}
