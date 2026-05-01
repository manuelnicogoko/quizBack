package com.example.proyectoquiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.domain.Notificacion;
import com.example.proyectoquiz.services.notificaciones.NotificacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {
    private final NotificacionService notificacionService;

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<?> getNotificacionesUsuario(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(notificacionService.getNotificacionesUsuario(userId));
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getNotificacionesAdmin() {
        return ResponseEntity.status(HttpStatus.OK).body(notificacionService.getNotificacionesAdmin());
    }

    @PutMapping("/{id}/leida")
    public ResponseEntity<?> marcarComoLeida(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.marcarComoLeida(id);
        return ResponseEntity.status(HttpStatus.OK).body(notificacion);
    }
}
