package keno.SnsChats.web;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatsDto {
    private Long id;
    private String title;
    private String createAt;

    public static ChatsDto mockChatsDto() {
        ChatsDto dto = new ChatsDto();
        dto.id = 2L;
        dto.title = "Hello Chats";
        dto.createAt = LocalDateTime.now().toString();
        return dto;
    }
}
