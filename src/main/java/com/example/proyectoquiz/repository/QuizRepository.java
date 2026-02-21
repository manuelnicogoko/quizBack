package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCategoriaId(Long categoriaId);

    List<Quiz> findBySubcategoriaId(Long subcategoriaId);

    List<Quiz> findByNombreContainingIgnoreCase(String nombre);
}
