package keno.SnsChats.web;

import lombok.Data;

import java.util.List;

@Data
public class ChatsDetailsDto {
    private Long id;
    private List<ChatsMessageDto> chatsMessages;

    public static ChatsDetailsDto createMock() {
        ChatsDetailsDto dto = new ChatsDetailsDto();
        dto.id = 4L;
        dto.chatsMessages = List.of(ChatsMessageDto.createMock(), ChatsMessageDto.createMock2());
        return dto;
    }
}
