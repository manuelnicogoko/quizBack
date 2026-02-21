package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Pregunta;
import com.example.proyectoquiz.domain.Quiz;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByQuizId(Long quizId);

    Pregunta findByQuizIdAndPosicion(Long quizId, Integer posicion);

    Quiz findQuizByPreguntaId(Long preguntaId);
}
