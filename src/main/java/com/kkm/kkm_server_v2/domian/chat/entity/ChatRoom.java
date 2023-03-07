package com.kkm.kkm_server_v2.domian.chat.entity;

import com.kkm.kkm_server_v2.domian.chat.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage,chatService);
    }
    private <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream()
                .forEach(session -> chatService.sendMessage(session,message));
    }

    public ChatRoom(String roomId, String name, Set<WebSocketSession> sessions) {
        this.roomId = roomId;
        this.name = name;
        this.sessions = sessions;
    }
    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }
}
