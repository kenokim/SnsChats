package keno.SnsChats.controller;

import keno.SnsChats.web.ChatsMessageSendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatsMessageController {

    @PostMapping("/chats/{chatsId}/message")
    public void send(@RequestBody ChatsMessageSendDto dto) {
        System.out.println(dto);
    }

}
