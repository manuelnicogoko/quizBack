package com.example.proyectoquiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.PreguntaDTO;
import com.example.proyectoquiz.services.pregunta.PreguntaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pregunta")
public class PreguntaController {

    private final PreguntaService preguntaService;

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getPreguntasByQuizId(@PathVariable Long quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.getPreguntasByQuizId(quizId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPreguntaById(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.getPreguntaById(id));
    }

    @GetMapping("/{quizId}/{posicion}")
    public ResponseEntity<?> getPreguntaByPosicion(@PathVariable Long quizId, @PathVariable Integer posicion)
            throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(preguntaService.getPreguntaByPosicion(quizId, posicion));
    }

    @PostMapping("/{quizId}")
    public ResponseEntity<?> savePregunta(@PathVariable Long quizId, @RequestBody PreguntaDTO preguntaDTO)
            throws RuntimeException {
        return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.savePregunta(quizId, preguntaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePregunta(@PathVariable Long id) {
        preguntaService.deletePregunta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
