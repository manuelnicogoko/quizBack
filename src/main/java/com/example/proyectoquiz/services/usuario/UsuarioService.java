package com.example.proyectoquiz.services.usuario;

import java.util.List;

import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.dto.UsuarioDTO;

public interface UsuarioService {

    public List<Usuario> getAllUsuarios();

    public Usuario getUsuarioById(Long id) throws RuntimeException;

    public Usuario updateUsuario(Long id, UsuarioDTO usuarioDTO) throws RuntimeException;

    public Usuario saveUsuario(RegisterDTO usuarioDTO) throws RuntimeException;

    public void deleteUsuario(Long id) throws RuntimeException;
}
