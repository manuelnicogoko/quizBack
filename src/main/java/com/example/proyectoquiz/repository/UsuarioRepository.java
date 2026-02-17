package com.example.proyectoquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
