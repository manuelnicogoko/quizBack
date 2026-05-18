package com.example.proyectoquiz.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El enunciado es obligatorio")
    @Size(min = 10, max = 200, message = "El enunciado de la pregunta debe tener entre 10 y 200 caracteres")
    private String enunciado;

    private String imagen;

    private Integer posicion;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quiz quiz;
}
