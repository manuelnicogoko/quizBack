package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nombre;

    private String email;

    private String password;

    private String avatar;

    private String rol;
}
