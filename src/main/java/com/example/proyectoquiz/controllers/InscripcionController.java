package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.domain.Inscripcion;
import com.example.proyectoquiz.dto.InscripcionDTO;
import com.example.proyectoquiz.services.inscripcion.InscripcionService;
import com.example.proyectoquiz.services.websocket.WebSocketService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/inscripcion")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    private final WebSocketService webSocketService;

    @GetMapping("/{codPartida}")
    public ResponseEntity<?> getInscripciones(@PathVariable String codPartida) {
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.getInscripcionesPorCodigo(codPartida));
    }

    @PostMapping("/")
    public ResponseEntity<?> createInscripcion(@RequestBody InscripcionDTO inscripcionDTO,
            @RequestHeader String codSocket) {
        Inscripcion inscripcion = inscripcionService.saveInscripcion(inscripcionDTO);
        webSocketService.unirJugador(codSocket);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcion);
    }

    @DeleteMapping("/{codigoInscripcion}")
    public ResponseEntity<?> deleteInscripcion(@PathVariable String codigoInscripcion,
            @RequestHeader String codSocket) {
        inscripcionService.deleteInscripcionPorCodigo(codigoInscripcion);
        webSocketService.excluirJugador(codSocket, codigoInscripcion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
