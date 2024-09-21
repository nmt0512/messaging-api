package com.thieunm.messaging_api.controller.socket;

import com.thieunm.messaging_api.dto.message.ChatMessage;
import com.thieunm.messaging_api.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/private-message")
    public void sendPrivateMessage(@Payload ChatMessage chatMessage) {
        log.info("Private message: {}", JsonUtils.parseObjectToJson(chatMessage));
        messagingTemplate.convertAndSendToUser(
                chatMessage.getReceivedUserId(),
                "/queue/messages",
                chatMessage.getMessageBody()
        );
    }
}
