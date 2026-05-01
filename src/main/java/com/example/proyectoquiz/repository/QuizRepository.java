package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCategoriaId(Long categoriaId);

    List<Quiz> findBySubcategoriaId(Long subcategoriaId);

    Page<Quiz> findByCategoriaIdAndEstado(Long categoriaId, Estado estado, Pageable pageable);

    Page<Quiz> findBySubcategoriaIdAndEstado(Long subcategoriaId, Estado estado, Pageable pageable);

    Page<Quiz> findByNombreContainingIgnoreCaseAndEstado(String nombre, Estado estado, Pageable pageable);

    Page<Quiz> findByCreadorId(Long creadorId, Pageable pageable);

    Page<Quiz> findByEstado(Estado estado, Pageable pageable);
}
