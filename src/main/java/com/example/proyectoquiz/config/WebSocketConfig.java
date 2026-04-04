package com.example.proyectoquiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // Producción
    @Value("${app.websocket.allowed-origin}")
    private String allowedOrigin;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Habilita un broker de mensajes sencillo para enviar datos al cliente
        // Los clientes se suscribirán a rutas que empiecen con /topic
        config.enableSimpleBroker("/topic");

        // Prefijo para los mensajes que van del cliente al servidor
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println("Allowed origin: " + allowedOrigin);
        // El punto de entrada para la conexión inicial del WebSocket
        registry.addEndpoint("/ws-cryptum")
                // allowed origin is read from application-*.properties
                .setAllowedOrigins("*")
                .setAllowedOriginPatterns("*");
        // .withSockJS()
        // .setSessionCookieNeeded(false);
    }

}