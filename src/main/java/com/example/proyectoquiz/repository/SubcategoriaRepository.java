package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Estado;
import com.example.proyectoquiz.domain.Subcategoria;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    List<Subcategoria> findByEstado(Estado estado);

    Subcategoria findByNombre(String nombre);
}
