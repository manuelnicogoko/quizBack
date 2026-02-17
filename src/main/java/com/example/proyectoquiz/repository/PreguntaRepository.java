package com.example.proyectoquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

}
