package com.example.proyectoquiz.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "nombre")
@Entity
public class ParametroApp {
    @Id
    @Size(max = 255)
    private String nombre;

    @NotNull
    @Size(max = 255)
    private String valor;

    @NotNull
    @Size(max = 255)
    private String tipoDato;
}
