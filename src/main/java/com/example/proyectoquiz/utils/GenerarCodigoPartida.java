package com.example.proyectoquiz.utils;

import org.springframework.stereotype.Component;

@Component
public class GenerarCodigoPartida {
    public String generarCodigoAleatorio() {
        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char letra = abecedario.charAt((int) (Math.random() * abecedario.length()));
        StringBuilder sb = new StringBuilder();
        sb.append(letra);
        for (int i = 0; i < 4; i++) {
            int digito = (int) (Math.random() * 10);
            sb.append(digito);
        }
        return sb.toString();
    }
}
