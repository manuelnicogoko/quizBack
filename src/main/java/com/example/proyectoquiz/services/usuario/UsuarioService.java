package com.example.proyectoquiz.services.usuario;

import java.util.List;

import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.dto.UsuarioDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface UsuarioService {

    public List<Usuario> getAllUsuarios();

    public Usuario getUsuarioById(Long id) throws RuntimeException;

    public Usuario updateUsuario(Long id, UsuarioDTO usuarioDTO)
            throws RuntimeException, UserNotFoundException, AuthException;

    public Usuario saveUsuario(RegisterDTO usuarioDTO) throws RuntimeException;

    public void deleteUsuario(Long id) throws RuntimeException, UserNotFoundException, AuthException;
}
