package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Jugada;

public interface JugadaRepository extends JpaRepository<Jugada, Long> {
    List<Jugada> findByPartidaCodigoAndRondaNumeroRonda(String codPartida, Integer numeroRonda);

    Long countByInscripcionIdAndRondaIdAndCorrectaFalse(Long inscripcionId, Long rondaId);
}
