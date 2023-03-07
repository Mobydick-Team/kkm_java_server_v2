package com.kkm.kkm_server_v2.domian.chat.presentation;

import com.kkm.kkm_server_v2.domian.chat.entity.ChatRoom;
import com.kkm.kkm_server_v2.domian.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
