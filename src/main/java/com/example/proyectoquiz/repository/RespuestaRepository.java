package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPreguntaId(Long preguntaId);
}
