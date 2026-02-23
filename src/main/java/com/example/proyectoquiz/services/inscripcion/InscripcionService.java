package com.example.proyectoquiz.services.inscripcion;

import java.util.List;

import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.dto.InscripcionDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface InscripcionService {
    public List<Inscripcion> getInscripciones(Long partidaId);

    public List<Inscripcion> getInscripcionesPorCodigo(String codigo);

    public Inscripcion saveInscripcion(InscripcionDTO inscripcionDTO) throws RuntimeException, UserNotFoundException;

    public void deleteInscripcion(Long id) throws RuntimeException;
}
