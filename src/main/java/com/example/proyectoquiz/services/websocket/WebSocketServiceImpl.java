package com.example.proyectoquiz.services.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    public void unirJugador(String idSocket) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket, "NJ");
    }

    public void excluirJugador(String idSocket, Long idInscripcion) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket, "OJ " + idInscripcion);
    }

    // WebSocket para notificar que se creo una nueva partida y recargar páginas
    // para unirse a públicas
    public void actualizarListado() {
        messagingTemplate.convertAndSend("/topic/partida/AL");
    }

    public void borrarPartida(String idSocket, Long idPartida) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket, "DP " + idPartida);
    }

    public void terminarPartida(String idSocket, String codPartida) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket, "TP " + codPartida);
    }

    public void nuevaRonda(String idSocket, Integer numeroRonda) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket, "NR " + numeroRonda);
    }

    public void terminarRonda(String idSocket, Integer numero) {
        messagingTemplate.convertAndSend("/topic/partida/" + idSocket,
                "TR " + numero);
    }

}
