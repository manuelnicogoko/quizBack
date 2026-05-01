package com.example.proyectoquiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByDestinatarioIdAndLeidaFalseOrderByFechaDesc(Long userId);

    List<Notificacion> findByDestinatarioIsNullAndLeidaFalseOrderByFechaDesc();
}