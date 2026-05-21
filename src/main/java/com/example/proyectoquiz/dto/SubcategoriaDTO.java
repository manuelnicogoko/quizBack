package com.example.proyectoquiz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Datos para crear una subcategoría")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaDTO {

    @Schema(description = "Nombre único de la subcategoría", example = "Astronomía", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Descripción breve de la subcategoría", example = "Preguntas sobre planetas, estrellas y el universo")
    private String descripcion;

    @Schema(description = "ID de la categoría a la que pertenece", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long categoriaId;
}
