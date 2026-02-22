package com.example.proyectoquiz.services.respuesta;

import java.util.List;

import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.dto.RespuestaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface RespuestaService {

    public List<Respuesta> getRespuestasByPreguntaId(Long preguntaId);

    public Respuesta getRespuestaById(Long id) throws RuntimeException;

    public Respuesta saveRespuesta(RespuestaDTO respuestaDTO) throws RuntimeException;

    public void deleteRespuesta(Long id) throws RuntimeException, UserNotFoundException, AuthException;
}
