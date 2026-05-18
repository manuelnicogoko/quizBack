package com.example.proyectoquiz.domain;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción del quiz debe tener entre 10 y 500 caracteres")
    private String descripcion;

    private Estado estado;

    private String portada;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Usuario creador;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Categoria categoria;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Subcategoria subcategoria;
}
