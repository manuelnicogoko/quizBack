package com.example.proyectoquiz.services.notificaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectoquiz.domain.Notificacion;
import com.example.proyectoquiz.repository.NotificacionRepository;
import com.example.proyectoquiz.services.websocket.WebSocketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {
    private final NotificacionRepository notificacionRepository;

    public void crearYNotificar(Notificacion notificacion, Long userId, WebSocketService wsService) {
        notificacionRepository.save(notificacion);
        if (userId != null) {
            wsService.notificacionQuizPendienteAprobacion(userId);
        } else {
            wsService.notificacionNuevoQuiz();
        }
    }

    public List<Notificacion> getNotificacionesUsuario(Long userId) {
        return notificacionRepository.findByDestinatarioIdAndLeidaFalseOrderByFechaDesc(userId);
    }

    public List<Notificacion> getNotificacionesAdmin() {
        return notificacionRepository.findByDestinatarioIsNullAndLeidaFalseOrderByFechaDesc();
    }

    public Notificacion marcarComoLeida(Long notificacionId) {
        Notificacion notificacion = notificacionRepository.findById(notificacionId).orElseThrow();
        notificacion.setLeida(true);
        return notificacionRepository.save(notificacion);
    }
}
