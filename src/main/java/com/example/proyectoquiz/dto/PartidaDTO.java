package com.example.proyectoquiz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Datos para crear una partida")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {

    @Schema(description = "Nombre de la partida", example = "Partida de los campeones", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Número máximo de jugadores permitidos", example = "4", minimum = "1", maximum = "10")
    private Integer maxJugadores;

    @Schema(description = "Indica si la partida es pública o privada", example = "true")
    private Boolean publica;

    @Schema(description = "Número de vidas por jugador", example = "3", minimum = "1")
    private Integer vidas;

    @Schema(description = "Tiempo en segundos por ronda", example = "30.0", minimum = "5.0")
    private Double tiempoRonda;

    @Schema(description = "ID del quiz que se usará en la partida", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long quiz;

    @Schema(description = "Nombre del anfitrión de la partida", example = "manuelgonzalez")
    private String nombreAnfitrion;
}
