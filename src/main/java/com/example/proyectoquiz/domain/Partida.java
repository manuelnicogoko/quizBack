package com.example.proyectoquiz.domain;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    private Boolean publica;

    private Integer vidas;

    private Double tiempoRonda;

    private LocalDate fechaCreacion;

    private Estado estado;

    private String codigo;

    private String codigoAnfitrion;

    private String codigoSocket;

    private Integer numeroJugadores;

    private String nombreAnfitrion;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Quiz quiz;

}
