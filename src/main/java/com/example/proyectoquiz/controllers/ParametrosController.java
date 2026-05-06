package com.example.proyectoquiz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.config.PropiedadesApp;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ParametrosController {
    private final PropiedadesApp propiedadesApp;

    @GetMapping("/parametros")
    public ResponseEntity<PropiedadesApp> obtenerParametros() {
        return ResponseEntity.ok(propiedadesApp);
    }
}
