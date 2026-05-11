package com.example.proyectoquiz.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaActualizacionDTO {

    private String enunciado;

    private String imagen;

    private List<String> pistas;

    private List<String> respuestas;

    private Integer posicion;
}
