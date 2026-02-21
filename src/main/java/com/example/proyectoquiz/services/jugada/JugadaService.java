package com.example.proyectoquiz.services.jugada;

import java.util.List;

import com.example.proyectoquiz.domain.Jugada;
import com.example.proyectoquiz.dto.JugadaDTO;

public interface JugadaService {
    public List<Jugada> getJugadasPartidaRonda(String codPartida, Integer numeroRonda);

    Jugada saveJugada(String codPartida, Integer numeroRonda, JugadaDTO jugadaDTO) throws RuntimeException;
}
