package com.example.proyectoquiz.services.usuario;

import com.example.proyectoquiz.domain.Rol;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class UsuarioServiceImplTest {

    ArrayList<Usuario> mockList;

    @InjectMocks
    UsuarioServiceImpl usuarioService;

    @Mock
    UsuarioRepository usuarioRepository;

    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        mockList.add(new Usuario(null, "Usuario 1", "usuario1@ejemplo.com", "password1", "img.png", Rol.ADMIN, null));
        mockList.add(new Usuario(null, "Usuario 2", "usuario2@ejemplo.com", "password2", "img.png", Rol.USER, null));
        mockList.add(new Usuario(null, "Usuario 3", "usuario3@ejemplo.com", "password3", "img.png", Rol.USER, null));
    }

    // Test obtener todos correcto
    @Test
    public void obtenerTodos() {
        when(usuarioRepository.findAll()).thenReturn(mockList);
        List<Usuario> usuarioList = usuarioService.getAllUsuarios();
        assertEquals(3, usuarioList.size());
        verify(usuarioRepository, times(1)).findAll();
    }

}