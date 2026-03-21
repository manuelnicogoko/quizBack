package com.example.proyectoquiz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  private AuthEntryPointJwt authEntryPointJwt;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPointJwt))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/h2-console/**").permitAll() // Permitir acceso a H2-console
            /* Categorias y Subcategorias */
            .requestMatchers(HttpMethod.POST, "/categoria/**", "/subcategoria/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.PUT, "/categoria/**", "/subcategoria/**").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/categoria/**", "/subcategoria/**").hasAnyRole("ADMIN")
            /* Usuarios */
            .requestMatchers("/usuario/all").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/usuario/{id}").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.PUT, "/usuario/{id}/register").permitAll()
            .requestMatchers(HttpMethod.DELETE, "/usuario/**").hasAnyRole("ADMIN", "USER")
            /* Partidas */
            .requestMatchers(HttpMethod.POST, "/partida/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.PUT, "/partida/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.DELETE, "/partida/**").hasAnyRole("ADMIN", "USER")
            /* Rondas */
            .requestMatchers(HttpMethod.POST, "/ronda/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.PUT, "/ronda/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.DELETE, "/ronda/**").hasAnyRole("ADMIN", "USER")
            /* Quizzes */
            .requestMatchers(HttpMethod.POST, "/quiz/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.PUT, "/quiz/**").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/quiz/**").hasAnyRole("ADMIN")
            /* Pregunta */
            .requestMatchers(HttpMethod.POST, "/pregunta/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.DELETE, "/pregunta/**").hasAnyRole("ADMIN")
            /* Pistas */
            .requestMatchers(HttpMethod.POST, "/pista/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.DELETE, "/pista/**").hasAnyRole("ADMIN")
            /* Respuestas */
            .requestMatchers(HttpMethod.POST, "/respuesta/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.DELETE, "/respuesta/**").hasAnyRole("ADMIN")
            .anyRequest().permitAll());
    http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); // Permitir iframes para
                                                                                           // H2-console
    http.authenticationProvider(authenticationProvider());
    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.cors(Customizer.withDefaults());
    return http.build();
  }
}
