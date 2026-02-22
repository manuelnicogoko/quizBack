package com.example.proyectoquiz.services.respuesta;

import java.util.List;

import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface RespuestaService {

    public List<Respuesta> getRespuestasByPreguntaId(Long preguntaId);

    public Respuesta getRespuestaById(Long id) throws RuntimeException;

    public Respuesta saveRespuesta(Respuesta respuesta);

    public void deleteRespuesta(Long id) throws RuntimeException, UserNotFoundException;
}
