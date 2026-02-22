package com.example.proyectoquiz.exceptions;

public class AuthException extends RuntimeException {
    public AuthException() {
        super("No se ha podido autenticar al usuario. Verifique sus credenciales e intente nuevamente.");
    }
}
