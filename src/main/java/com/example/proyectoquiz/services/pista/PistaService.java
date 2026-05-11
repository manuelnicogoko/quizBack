package com.example.proyectoquiz.services.pista;

import java.util.List;

import com.example.proyectoquiz.domain.Pista;
import com.example.proyectoquiz.dto.PistaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface PistaService {

    public List<Pista> getPistasByPreguntaId(Long preguntaId);

    public Pista getPistaById(Long id) throws RuntimeException;

    public Pista savePista(PistaDTO pistaDTO) throws RuntimeException;

    public void deletePista(Long id) throws RuntimeException, UserNotFoundException, AuthException;

    public void actualizarPistasDePregunta(Long preguntaId, List<String> nuevasPistas) throws RuntimeException;
}
