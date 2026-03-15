package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCategoriaId(Long categoriaId);

    List<Quiz> findBySubcategoriaId(Long subcategoriaId);

    List<Quiz> findByCategoriaIdAndEstado(Long categoriaId, Estado estado);

    List<Quiz> findBySubcategoriaIdAndEstado(Long subcategoriaId, Estado estado);

    List<Quiz> findByNombreContainingIgnoreCaseAndEstado(String nombre, Estado estado);

    List<Quiz> findByEstado(Estado estado);
}
