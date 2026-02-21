package com.example.proyectoquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Ronda;

public interface RondaRepository extends JpaRepository<Ronda, Long> {
    Ronda findByPartidaAndNumeroRonda(Long partidaId, Integer numeroRonda);
}
