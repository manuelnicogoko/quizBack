package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadaDTO {

    private String respuesta;

    private Double tiempoRespuesta;

}
