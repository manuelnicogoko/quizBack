package com.example.proyectoquiz.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer maxJugadores;

    private boolean publica;

    private Integer vidas;

    private Double tiempoRonda;

    private LocalDateTime fechaCreacion;

    private Estado estado;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Usuario usuario;
}
