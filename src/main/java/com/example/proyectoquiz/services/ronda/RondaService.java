package com.example.proyectoquiz.services.ronda;

import com.example.proyectoquiz.domain.Ronda;
import com.example.proyectoquiz.dto.RondaDTO;

public interface RondaService {

    public Ronda getRondaById(Long id) throws RuntimeException;

    public Ronda saveRonda(String codPartida, RondaDTO rondaDTO) throws RuntimeException;

    public void deleteRonda(Long id);

    public Ronda finalizarRonda(Long id) throws RuntimeException;
}
