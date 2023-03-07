package com.kkm.kkm_server_v2.domian.chat.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkm.kkm_server_v2.domian.chat.entity.ChatMessage;
import com.kkm.kkm_server_v2.domian.chat.entity.ChatRoom;
import com.kkm.kkm_server_v2.domian.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component @Primary
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatSerivce;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        String payload = textMessage.getPayload();
        log.info("{}",payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);

        ChatRoom chatRoom = chatSerivce.findRoomById(chatMessage.getRoomId());
        chatRoom.handleActions(session, chatMessage, chatSerivce);
    }
}
