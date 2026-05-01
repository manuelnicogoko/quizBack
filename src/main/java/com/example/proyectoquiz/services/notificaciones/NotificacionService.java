package com.example.proyectoquiz.services.notificaciones;

import java.util.List;

import com.example.proyectoquiz.domain.Notificacion;
import com.example.proyectoquiz.services.websocket.WebSocketService;

public interface NotificacionService {
    public List<Notificacion> getNotificacionesUsuario(Long userId);

    public List<Notificacion> getNotificacionesAdmin();

    public Notificacion marcarComoLeida(Long notificacionId);

    public void crearYNotificar(Notificacion notificacion, Long userId, WebSocketService wsService);
}
