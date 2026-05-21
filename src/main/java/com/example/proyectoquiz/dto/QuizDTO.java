package com.example.proyectoquiz.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Datos para crear un quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

    @Schema(description = "Nombre del quiz", example = "¿Cuánto sabes de astronomía?", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Descripción del quiz", example = "Pon a prueba tus conocimientos sobre el universo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String descripcion;

    @Schema(description = "ID de la categoría del quiz", example = "1")
    private Long categoriaId;

    @Schema(description = "ID de la subcategoría del quiz", example = "3")
    private Long subcategoriaId;

    @Schema(description = "URL de la imagen de portada del quiz", example = "https://res.cloudinary.com/.../portada.jpg")
    private String portada;

    @Schema(description = "Lista de preguntas que componen el quiz")
    private List<PreguntaDTO> preguntas;
}
