package com.example.proyectoquiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.JwtResponseDTO;
import com.example.proyectoquiz.dto.LoginDTO;
import com.example.proyectoquiz.dto.MessageResponse;
import com.example.proyectoquiz.dto.RegisterDTO;
import com.example.proyectoquiz.exceptions.CredencialesIncorrectasException;
import com.example.proyectoquiz.repository.UsuarioRepository;
import com.example.proyectoquiz.security.JwtUtils;
import com.example.proyectoquiz.security.UserDetailsImpl;
import com.example.proyectoquiz.services.usuario.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  private final UsuarioService usuarioService;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);

      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      String rol = userDetails.getAuthorities().stream().findFirst().map(a -> a.getAuthority()).orElse("ERROR");

      return ResponseEntity.ok(new JwtResponseDTO(jwt, "Bearer",
          userDetails.getId(),
          userDetails.getUsername(),
          userDetails.getEmail(),
          rol));
    } catch (Exception e) {
      throw new CredencialesIncorrectasException();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO signUpRequest) {
    if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Ya existe un usuario con ese email"));
    }

    return ResponseEntity.ok(usuarioService.saveUsuario(signUpRequest));
  }

  @GetMapping("/validate")
  public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
    return ResponseEntity.ok(usuarioService.validateUserToken(authHeader.substring(7)));
  }
}
