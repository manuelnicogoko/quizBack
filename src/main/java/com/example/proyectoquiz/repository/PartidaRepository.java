package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findByPublicaTrue();

    Partida findByCodigo(String codigo);

}
