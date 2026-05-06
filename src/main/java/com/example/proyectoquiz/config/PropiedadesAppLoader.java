package com.example.proyectoquiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.example.proyectoquiz.domain.ParametroApp;
import com.example.proyectoquiz.repository.ParametroAppRepository;

import lombok.RequiredArgsConstructor;

@Configuration
// Ensure this configuration is initialized after Spring's SQL initializer so
// that
// values inserted by data.sql are available when the bean is created.
// In environments where the SQL initializer bean is not present (prod when
// spring.sql.init.mode=never), this will have no effect.
@DependsOn("dataSourceScriptDatabaseInitializer")
@RequiredArgsConstructor
public class PropiedadesAppLoader {
    private final ParametroAppRepository parametroAppRepository;

    @Bean
    public PropiedadesApp propiedadesApp() {

        int maxPartidasJugando = getIntValue("maxPartidasJugando"); // 20
        int maxPartidasPendientes = getIntValue("maxPartidasPendientes"); // 30
        int maxJugadorPartida = getIntValue("maxJugadorPartida"); // 20
        int minJugadorPartida = getIntValue("minJugadorPartida"); // 1
        int maxPreguntas = getIntValue("maxPreguntas"); // 20
        int minPreguntas = getIntValue("minPreguntas"); // 3
        int maxTiempoRonda = getIntValue("maxTiempoRonda"); // 60
        int minTiempoRonda = getIntValue("minTiempoRonda"); // 10
        int maxQuizzesCreados = getIntValue("maxQuizzesCreados"); // 80
        int maxUsuariosCreados = getIntValue("maxUsuariosCreados"); // 200
        int maxCategoriasCreadas = getIntValue("maxCategoriasCreadas"); // 50
        int maxSubcategoriasCreadas = getIntValue("maxSubcategoriasCreadas"); // 100
        int maxVidas = getIntValue("maxVidas"); // 4
        int minVidas = getIntValue("minVidas"); // 1
        int maxPistasRespuestas = getIntValue("maxPistasRespuestas"); // 5

        return PropiedadesApp.builder()
                .maxPartidasJugando(maxPartidasJugando)
                .maxPartidasPendientes(maxPartidasPendientes)
                .maxJugadorPartida(maxJugadorPartida)
                .minJugadorPartida(minJugadorPartida)
                .maxPreguntas(maxPreguntas)
                .minPreguntas(minPreguntas)
                .maxTiempoRonda(maxTiempoRonda)
                .minTiempoRonda(minTiempoRonda)
                .maxQuizzesCreados(maxQuizzesCreados)
                .maxUsuariosCreados(maxUsuariosCreados)
                .maxCategoriasCreadas(maxCategoriasCreadas)
                .maxSubcategoriasCreadas(maxSubcategoriasCreadas)
                .maxVidas(maxVidas)
                .minVidas(minVidas)
                .maxPistasRespuestas(maxPistasRespuestas)
                .build();
    }

    private int getIntValue(String nombre) {
        return parametroAppRepository.findById(nombre)
                .map(ParametroApp::getValor)
                .map(Integer::parseInt)
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró el parámetro requerido: " + nombre));
    }
}