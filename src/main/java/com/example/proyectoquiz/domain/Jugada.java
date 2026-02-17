package com.example.proyectoquiz.domain;

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
public class Jugada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuesta;

    private boolean correcta;

    private Long puntuacion;

    private Double tiempoRespuesta;

    @ManyToOne
    private Partida partida;

    @ManyToOne
    private Ronda ronda;

    @ManyToOne
    private Usuario usuario;
}
