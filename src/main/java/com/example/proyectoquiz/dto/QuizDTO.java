package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

    private String nombre;

    private String descripcion;

    private Long categoriaId;

    private Long subcategoriaId;
}
