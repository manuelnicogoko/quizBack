package com.example.proyectoquiz.exceptions;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String path) {
        super("No se encontró el archivo: " + path);
    }
}
