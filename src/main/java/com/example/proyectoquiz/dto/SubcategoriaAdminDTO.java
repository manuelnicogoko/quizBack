package com.example.proyectoquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaAdminDTO {

    private String nombre;

    private String logo;

    private String descripcion;

    private Long categoriaId;
}
