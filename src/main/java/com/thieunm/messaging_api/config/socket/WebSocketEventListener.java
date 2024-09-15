package com.thieunm.messaging_api.config.socket;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@AllArgsConstructor
public class WebSocketEventListener {

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        log.info("WebSocket handshake completed: {}", event.getMessage());
    }

    @EventListener
    private void handleSessionConnected(SessionConnectedEvent event) {
        log.info("Connected: {}", event.getMessage());
    }

    @EventListener
    private void handleSessionDisconnected(SessionDisconnectEvent event) {
        log.info("Disconnected: {}", event.getMessage());
    }

}
