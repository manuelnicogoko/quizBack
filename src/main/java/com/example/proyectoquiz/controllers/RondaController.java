package com.example.proyectoquiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.RondaDTO;
import com.example.proyectoquiz.services.ronda.RondaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ronda")
public class RondaController {

    private final RondaService rondaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRondaById(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(rondaService.getRondaById(id));
    }

    @PostMapping("/{codPartida}")
    public ResponseEntity<?> saveRonda(@PathVariable String codPartida, @RequestBody RondaDTO rondaDTO)
            throws RuntimeException {
        return ResponseEntity.status(HttpStatus.CREATED).body(rondaService.saveRonda(codPartida, rondaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRonda(@PathVariable Long id) {
        rondaService.deleteRonda(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<?> finalizarRonda(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(rondaService.finalizarRonda(id));
    }

}
