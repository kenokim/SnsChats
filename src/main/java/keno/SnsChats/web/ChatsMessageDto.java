package keno.SnsChats.web;

import lombok.Data;

@Data
public class ChatsMessageDto {
    private Long id;
    private String content;

    public static ChatsMessageDto createMock() {
        ChatsMessageDto dto = new ChatsMessageDto();
        dto.id = 4L;
        dto.content = "Hello Keno";
        return dto;
    }
    public static ChatsMessageDto createMock2() {
        ChatsMessageDto dto = new ChatsMessageDto();
        dto.id = 5L;
        dto.content = "Hello Tymes";
        return dto;
    }
}
