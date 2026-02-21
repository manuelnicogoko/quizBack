package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {

    private String nombre;

    private Integer maxJugadores;

    private Boolean publica;

    private Integer vidas;

    private Double tiempoRonda;

    private String codigo;

    private Long quiz;
}
