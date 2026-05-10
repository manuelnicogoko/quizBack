package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findByPublicaTrueAndEstado(Estado estado);

    Partida findByCodigoAndEstado(String codigo, Estado estado);

    Partida findByCodigoAndEstadoIn(String codigo, List<Estado> estados);

    long countByEstado(Estado estado);
}
