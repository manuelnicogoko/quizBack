package com.example.proyectoquiz.exceptions;

public class CredencialesIncorrectasException extends RuntimeException {
    public CredencialesIncorrectasException() {
        super("Credenciales incorrectas");
    }
}
