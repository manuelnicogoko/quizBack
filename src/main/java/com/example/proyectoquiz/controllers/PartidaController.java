package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.domain.Partida;
import com.example.proyectoquiz.dto.PartidaDTO;
import com.example.proyectoquiz.services.partida.PartidaService;
import com.example.proyectoquiz.services.websocket.WebSocketService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partida")
public class PartidaController {

    private final PartidaService partidaService;

    private final WebSocketService webSocketService;

    @GetMapping("/all")
    public ResponseEntity<?> getPartidasPublicas() {
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.getPartidasPublicas());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getPartidaByCodigo(@PathVariable String codigo) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.getPartidaByCodigo(codigo));
    }

    @PostMapping("/")
    public ResponseEntity<?> createPartida(@RequestBody PartidaDTO partidaDTO) {
        Partida partida = partidaService.savePartida(partidaDTO);
        webSocketService.actualizarListado();
        return ResponseEntity.status(HttpStatus.CREATED).body(partida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePartida(@PathVariable Long id) {
        partidaService.deletePartida(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/empezar/{codigoPartida}")
    public ResponseEntity<?> empezarPartida(@PathVariable String codigoPartida, @RequestHeader String codSocket) {
        Partida partida = partidaService.empezarPartida(codigoPartida);
        webSocketService.actualizarListado();
        return ResponseEntity.status(HttpStatus.OK).body(partida);
    }

    @PutMapping("/cancelar/{codigoPartida}")
    public ResponseEntity<?> cancelarPartida(@PathVariable String codigoPartida, @RequestHeader String codSocket) {
        Partida partida = partidaService.cancelarPartida(codigoPartida);
        webSocketService.cancelarPartida(codSocket);
        webSocketService.actualizarListado();
        return ResponseEntity.status(HttpStatus.OK).body(partida);
    }

    @PutMapping("/finalizar/{codigo}")
    public ResponseEntity<?> finalizarPartida(@PathVariable String codigo, @RequestHeader String codSocket) {
        webSocketService.terminarPartida(codSocket, codigo);
        webSocketService.actualizarListado();
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.finalizarPartida(codigo));
    }
}
