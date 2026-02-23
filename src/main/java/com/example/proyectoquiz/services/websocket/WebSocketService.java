package com.example.proyectoquiz.services.websocket;

public interface WebSocketService {

    public void unirJugador(String idSocket);

    public void excluirJugador(String idSocket, Long idInscripcion);

    public void actualizarListado();

    public void borrarPartida(String idSocket, Long idPartida);

    public void terminarPartida(String idSocket, String codInscripcionPartida);

    public void nuevaRonda(String idSocket, Integer numeroRonda);

    public void terminarRonda(String idSocket, Integer numero);
}
