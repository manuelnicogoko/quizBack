package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.domain.Estado;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByEstado(Estado estado);

    Categoria findByNombreIgnoreCase(String nombre);
}
