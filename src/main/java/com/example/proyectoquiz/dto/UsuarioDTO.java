package com.example.proyectoquiz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Datos del usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Schema(description = "Nombre único del usuario", example = "manuelgonzalez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Correo electrónico del usuario", example = "manuel@ejemplo.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "Contraseña del usuario (mínimo 8 caracteres)", example = "Password123!")
    private String password;

    @Schema(description = "URL del avatar del usuario", example = "https://res.cloudinary.com/.../avatar.jpg")
    private String avatar;

    @Schema(description = "Rol del usuario en el sistema", example = "USER", allowableValues = {"USER", "ADMIN"})
    private String rol;
}
