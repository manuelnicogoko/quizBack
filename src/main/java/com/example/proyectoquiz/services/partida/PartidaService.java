package com.example.proyectoquiz.services.partida;

import java.util.List;

import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.dto.PartidaDTO;
import com.example.proyectoquiz.dto.PartidaListadoDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PartidaNotFoundException;
import com.example.proyectoquiz.exceptions.PropiedadAppException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface PartidaService {

        public List<Partida> getAllPartidas();

        public List<PartidaListadoDTO> getPartidasPublicas();

        public PartidaListadoDTO getPartidaByCodigo(String codigo) throws RuntimeException, PartidaNotFoundException;

        public Partida savePartida(PartidaDTO partidaDTO)
                        throws RuntimeException, UserNotFoundException, AuthException, PropiedadAppException;

        public void deletePartida(Long id) throws RuntimeException, UserNotFoundException, AuthException;

        public Partida empezarPartida(String codigo) throws RuntimeException, PartidaNotFoundException;

        public Partida cancelarPartida(String codigo) throws RuntimeException, PartidaNotFoundException;

        public Partida finalizarPartida(String codigo)
                        throws RuntimeException, PartidaNotFoundException;

}
