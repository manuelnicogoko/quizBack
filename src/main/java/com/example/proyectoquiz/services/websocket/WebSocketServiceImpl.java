package com.example.proyectoquiz.services.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    public void unirJugador(String codSocket) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "NJ");
    }

    public void excluirJugador(String codSocket, String codigoInscripcion) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "OJ " + codigoInscripcion);
        actualizarJugadores(codSocket);
    }

    public void actualizarJugadores(String codSocket) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "AJ");
    }

    // WebSocket para notificar que se creo una nueva partida y recargar páginas
    // para unirse a públicas
    public void actualizarListado() {
        messagingTemplate.convertAndSend("/topic/partida/AL", "ACTUALIZAR_LISTADO");
    }

    public void cancelarPartida(String codSocket) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "CP ");
    }

    public void terminarPartida(String codSocket, String codPartida) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "TP " + codPartida);
    }

    public void nuevaRonda(String codSocket, Integer numeroRonda) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket, "NR " + numeroRonda);
    }

    public void terminarRonda(String codSocket, Integer numero) {
        messagingTemplate.convertAndSend("/topic/partida/" + codSocket,
                "TR " + numero);
    }
}
