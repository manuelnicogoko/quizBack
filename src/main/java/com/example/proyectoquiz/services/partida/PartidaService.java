package com.example.proyectoquiz.services.partida;

import java.util.List;

import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.dto.PartidaDTO;

public interface PartidaService {

    public List<Partida> getAllPartidas();

    public List<Partida> getPartidasPublicas();

    public Partida getPartidaByCodigo(String codigo) throws RuntimeException;

    public Partida savePartida(PartidaDTO partidaDTO) throws RuntimeException;

    public void deletePartida(Long id) throws RuntimeException;

    public Partida finalizarPartida(String codigo) throws RuntimeException;

}
