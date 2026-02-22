package com.example.proyectoquiz.services.partida;

import java.util.List;

import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.dto.PartidaDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface PartidaService {

    public List<Partida> getAllPartidas();

    public List<Partida> getPartidasPublicas();

    public Partida getPartidaByCodigo(String codigo) throws RuntimeException;

    public Partida savePartida(PartidaDTO partidaDTO) throws RuntimeException, UserNotFoundException;

    public void deletePartida(Long id) throws RuntimeException;

    public Partida finalizarPartida(String codigo) throws RuntimeException;

}
