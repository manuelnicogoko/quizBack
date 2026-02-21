package com.example.proyectoquiz.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("No se encontró el usuario con email: " + email);
    }
}
