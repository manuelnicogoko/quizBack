package com.example.proyectoquiz.services.jugada;

import java.util.List;

import com.example.proyectoquiz.domain.Jugada;
import com.example.proyectoquiz.dto.JugadaDTO;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface JugadaService {
    public List<Jugada> getJugadasPartidaRonda(String codPartida, Integer numeroRonda);

    public Jugada saveJugada(String codPartida, Integer numeroRonda, JugadaDTO jugadaDTO)
            throws RuntimeException, UserNotFoundException, PartidaNotFoundException;
}
