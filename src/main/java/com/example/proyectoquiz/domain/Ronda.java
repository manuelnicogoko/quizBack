package com.example.proyectoquiz.domain;

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
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroRonda;

    private Estado estado;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Partida partida;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pregunta pregunta;
}
