package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    Usuario findByEmail(String email);

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);
}
