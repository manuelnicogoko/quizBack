package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.domain.Partida;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByPartidaId(Long partidaId);

    Inscripcion findByCodigoInscripcion(String codigoInscripcion);

    List<Inscripcion> findByPartidaCodigo(String codigo);

    Inscripcion findByUsuarioIdAndPartidaId(Long usuarioId, Long partidaId);

    boolean existsByPartidaAndNombre(Partida partida, String nombre);

    Inscripcion findByCodigoInscripcionAndPartidaId(String codigoInscripcion, Long partidaId);

}
