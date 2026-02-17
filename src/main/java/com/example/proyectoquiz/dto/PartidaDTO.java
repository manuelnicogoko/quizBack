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

    private boolean publica;

    private Integer vidas;

    private Double tiempoRonda;
}
