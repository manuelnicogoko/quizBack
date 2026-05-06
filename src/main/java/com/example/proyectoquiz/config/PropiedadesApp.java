package com.example.proyectoquiz.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PropiedadesApp {
    private final int maxPartidasJugando;
    private final int maxPartidasPendientes;
    private final int maxJugadorPartida;
    private final int minJugadorPartida;
    private final int maxQuizzesCreados;
    private final int maxPreguntas;
    private final int minPreguntas;
    private final int maxTiempoRonda;
    private final int minTiempoRonda;
    private final int maxUsuariosCreados;
    private final int maxCategoriasCreadas;
    private final int maxSubcategoriasCreadas;
    private final int maxVidas;
    private final int minVidas;
    private final int maxPistasRespuestas;
}