package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.JugadaDTO;
import com.example.proyectoquiz.services.jugada.JugadaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jugada")
public class JugadaController {

    private final JugadaService jugadaService;

    @GetMapping("/{codPartida}/{numeroRonda}")
    public ResponseEntity<?> getJugadasPartidaRonda(@PathVariable String codPartida,
            @PathVariable Integer numeroRonda) {
        return ResponseEntity.status(HttpStatus.OK).body(jugadaService.getJugadasPartidaRonda(codPartida, numeroRonda));
    }

    @PostMapping("/{codPartida}/{numeroRonda}")
    public ResponseEntity<?> saveJugada(@PathVariable String codPartida,
            @PathVariable Integer numeroRonda, @RequestBody JugadaDTO jugadaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jugadaService.saveJugada(codPartida, numeroRonda, jugadaDTO));

    }
}
