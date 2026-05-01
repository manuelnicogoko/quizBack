package com.example.proyectoquiz.services.websocket;

public interface WebSocketService {

    public void unirJugador(String idSocket);

    public void excluirJugador(String codSocket, String codigoInscripcion);

    public void actualizarJugadores(String codSocket);

    public void actualizarListado();

    public void cancelarPartida(String codSocket);

    public void terminarPartida(String idSocket, String codInscripcionPartida);

    public void nuevaRonda(String idSocket, Integer numeroRonda);

    public void terminarRonda(String idSocket, Integer numero);

    public void notificacionQuizPendienteAprobacion(Long userId);

    public void notificacionNuevoQuiz();
}
