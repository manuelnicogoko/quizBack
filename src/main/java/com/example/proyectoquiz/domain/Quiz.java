package com.example.proyectoquiz.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    private String nombre;

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
