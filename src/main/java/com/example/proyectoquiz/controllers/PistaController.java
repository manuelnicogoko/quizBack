package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.domain.Pista;
import com.example.proyectoquiz.services.pista.PistaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pista")
public class PistaController {

    private final PistaService pistaService;

    @GetMapping("/{preguntaId}")
    public ResponseEntity<?> getPistasByPreguntaId(@PathVariable Long preguntaId) {
        return ResponseEntity.status(HttpStatus.OK).body(pistaService.getPistasByPreguntaId(preguntaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPistaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pistaService.getPistaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> savePista(@RequestBody Pista pista) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pistaService.savePista(pista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePista(@PathVariable Long id) {
        pistaService.deletePista(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
