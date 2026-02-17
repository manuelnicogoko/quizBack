package com.example.proyectoquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
