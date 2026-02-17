package com.example.proyectoquiz.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTO {

    private String enunciado;

    private String imagen;

    private Integer posicion;

    private List<String> pistas;

    private List<String> respuestas;
}
