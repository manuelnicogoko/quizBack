package com.example.proyectoquiz.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizAdminDTO {

    private String nombre;

    private String descripcion;

    private Long categoriaId;

    private Long subcategoriaId;

    private String portada;

    private List<PreguntaDTO> preguntas;

    private String estado;

}
