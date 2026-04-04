package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaListadoDTO {

    private Long id;

    private String nombre;

    private Integer maxJugadores;

    private Integer numeroJugadores;

    private Boolean publica;

    private Integer vidas;

    private Double tiempoRonda;

    private String codigo;

    private String codigoSocket;

    private String quiz;

    private String codigoAnfitrion;

    private Long quizId;

}
