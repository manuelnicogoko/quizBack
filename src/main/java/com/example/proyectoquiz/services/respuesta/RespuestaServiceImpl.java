package com.example.proyectoquiz.services.respuesta;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RespuestaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;
import com.example.proyectoquiz.repository.PreguntaRepository;
import com.example.proyectoquiz.repository.RespuestaRepository;
import com.example.proyectoquiz.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;

    private final PreguntaRepository preguntaRepository;

    private final UsuarioRepository usuarioRepository;

    public List<Respuesta> getRespuestasByPreguntaId(Long preguntaId) {
        return respuestaRepository.findByPreguntaId(preguntaId);
    }

    public Respuesta getRespuestaById(Long id) throws RuntimeException {
        return respuestaRepository.findById(id).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
    }

    public Respuesta saveRespuesta(RespuestaDTO respuestaDTO) throws RuntimeException {
        Pregunta pregunta = preguntaRepository.findById(respuestaDTO.getPreguntaId())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

        Respuesta respuesta = new Respuesta();
        respuesta.setTexto(respuestaDTO.getTexto());
        respuesta.setPregunta(pregunta);

        return respuestaRepository.save(respuesta);
    }

    public void deleteRespuesta(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar esta respuesta");
        }

        respuestaRepository.deleteById(id);
    }
}
