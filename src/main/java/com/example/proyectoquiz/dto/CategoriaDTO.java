package com.example.proyectoquiz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Datos para crear una categoría")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    @Schema(description = "Nombre único de la categoría", example = "Ciencia", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Descripción breve de la categoría", example = "Preguntas sobre ciencia y naturaleza")
    private String descripcion;
}
