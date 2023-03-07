package com.kkm.kkm_server_v2.domian.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChatMessage {
    public enum MessageType {
        ENTER, TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

    public MessageType getType() {
        return type;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

