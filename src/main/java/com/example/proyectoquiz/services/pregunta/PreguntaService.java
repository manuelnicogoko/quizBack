package com.example.proyectoquiz.services.pregunta;

import java.util.List;

import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.dto.PreguntaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface PreguntaService {
    public List<Pregunta> getPreguntasByQuizId(Long quizId);

    public Pregunta savePregunta(Long quizId, PreguntaDTO preguntaDTO) throws RuntimeException;

    public Pregunta getPreguntaById(Long id) throws RuntimeException;

    public Pregunta getPreguntaByPosicion(Long quizId, Integer posicion) throws RuntimeException;

    public void deletePregunta(Long id) throws RuntimeException, UserNotFoundException, AuthException;
}
