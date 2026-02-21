package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Pista;

public interface PistaRepository extends JpaRepository<Pista, Long> {

    List<Pista> findByPreguntaId(Long preguntaId);
}
