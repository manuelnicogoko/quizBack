package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByPartidaId(Long partidaId);

    List<Inscripcion> findByPartidaCodigo(String codigo);

    Inscripcion findByUsuarioIdAndPartidaId(Long usuarioId, Long partidaId);

}
