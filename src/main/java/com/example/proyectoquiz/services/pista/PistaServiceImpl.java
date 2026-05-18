package com.example.proyectoquiz.services.pista;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Pista;
import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.PistaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
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

    public Pista savePista(PistaDTO pistaDTO) throws RuntimeException {
        Pregunta pregunta = preguntaRepository.findById(pistaDTO.getPreguntaId())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

        Pista pista = new Pista();
        pista.setTexto(Jsoup.clean(pistaDTO.getTexto(), Safelist.basic()));
        pista.setPregunta(pregunta);

        return pistaRepository.save(pista);
    }

    public void deletePista(Long id) throws RuntimeException, UserNotFoundException, AuthException {
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
            throw new RuntimeException("No tienes permisos para eliminar esta pista");
        }

        pistaRepository.deleteById(id);
    }

    public void actualizarPistasDePregunta(Long preguntaId, List<String> nuevasPistas) throws RuntimeException {
        List<Pista> actuales = pistaRepository.findByPreguntaId(preguntaId);
        pistaRepository.deleteAll(actuales);
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        for (String texto : nuevasPistas) {
            Pista pista = new Pista();
            pista.setTexto(Jsoup.clean(texto, Safelist.basic()));
            pista.setPregunta(pregunta);
            pistaRepository.save(pista);
        }
    }

}
