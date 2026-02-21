package com.example.proyectoquiz.exceptions;

public class PartidaNotFoundException extends RuntimeException {
    public PartidaNotFoundException(String codigo) {
        super("No se encontró la partida con el código: " + codigo);
    }
}
