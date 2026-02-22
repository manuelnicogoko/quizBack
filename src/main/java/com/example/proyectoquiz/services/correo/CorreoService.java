package com.example.proyectoquiz.services.correo;

public interface CorreoService {
    boolean enviarEmail(String destination, String subject, String textMessage);
}
