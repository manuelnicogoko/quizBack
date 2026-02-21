package com.example.proyectoquiz.services.respuesta;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
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

    public Respuesta saveRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public void deleteRespuesta(Long id) throws RuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Usuario usuario = usuarioRepository.findByNombre(username);

        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

        Quiz quiz = preguntaRepository.findQuizByPreguntaId(respuesta.getPregunta().getId());

        if (usuario.getRol() != Rol.ADMIN && quiz.getCreador().getId() != usuario.getId()) {
            throw new RuntimeException("No tienes permisos para eliminar esta respuesta");
        }

        respuestaRepository.deleteById(id);
    }
}
