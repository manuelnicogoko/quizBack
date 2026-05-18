package com.example.proyectoquiz.controllers.usuario;

import com.example.proyectoquiz.controllers.AuthController;
import com.example.proyectoquiz.controllers.UsuarioController;
import com.example.proyectoquiz.domain.Usuario;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.services.usuario.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class UsuarioControllerTest {

    ArrayList<Usuario> mockList;

    @InjectMocks
    private UsuarioController usuarioController;
    private AuthController authController;

    @MockitoBean
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNombre("Usuario1");
        mockList.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombre("Usuario2");
        mockList.add(usuario2);
    }

    // Test alta
    @Test
    public void crearUsuario() throws Exception {

        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setNombre("NuevoUsuario");
        registerDTO.setEmail("nuevo@correo.com");
        registerDTO.setPassword("passwordSeguro123");
        registerDTO.setRol("USER");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("NuevoUsuario");

        when(usuarioService.saveUsuario(any())).thenReturn(usuario);

        mockMvc.perform(post("/usuario/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("NuevoUsuario")));
    }

}