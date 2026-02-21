package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.domain.Respuesta;
import com.example.proyectoquiz.services.respuesta.RespuestaService;

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
@RequestMapping("/respuesta")
public class RespuestaController {

    private final RespuestaService respuestaService;

    @GetMapping("/{preguntaId}")
    public ResponseEntity<?> getRespuestasByPreguntaId(@PathVariable Long preguntaId) {
        return ResponseEntity.status(HttpStatus.OK).body(respuestaService.getRespuestasByPreguntaId(preguntaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRespuestaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(respuestaService.getRespuestaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveRespuesta(@RequestBody Respuesta respuesta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.saveRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRespuesta(@PathVariable Long id) {
        respuestaService.deleteRespuesta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
