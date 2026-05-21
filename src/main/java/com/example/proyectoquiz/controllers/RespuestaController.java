package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.RespuestaDTO;
import com.example.proyectoquiz.services.respuesta.RespuestaService;

import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/pregunta/{preguntaId}")
    @Operation(summary = "Listar todas las respuestas por pregunta", description = "Devuelve todas las respuestas asociadas a una pregunta específica")
    public ResponseEntity<?> getRespuestasByPreguntaId(@PathVariable Long preguntaId) {
        return ResponseEntity.status(HttpStatus.OK).body(respuestaService.getRespuestasByPreguntaId(preguntaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRespuestaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(respuestaService.getRespuestaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.saveRespuesta(respuestaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRespuesta(@PathVariable Long id) {
        respuestaService.deleteRespuesta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
