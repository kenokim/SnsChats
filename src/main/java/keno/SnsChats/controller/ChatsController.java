package keno.SnsChats.controller;

import keno.SnsChats.domain.Chats;
import keno.SnsChats.security.CurrentMember;
import keno.SnsChats.service.ChatsService;
import keno.SnsChats.web.ChatsCreateDto;
import keno.SnsChats.web.ChatsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatsController {

    private final ChatsService chatsService;
    private final CurrentMember currentMember;

    private final ModelMapper modelMapper;

    @GetMapping("/{chatsId}")
    public ChatsDto findChatsById(@PathVariable("chatsId") Long chatsId) {
        return convertToDto(chatsService.findChatsById(chatsId));
    }

    @PostMapping
    public ResponseEntity createChats(ChatsCreateDto dto) {
        chatsService.create(dto.getTitle(), dto.getMaxMember(), currentMember.id());
        return new ResponseEntity(HttpStatus.OK);
    }

    private ChatsDto convertToDto(Chats chats) {
        ChatsDto dto = modelMapper.map(chats, ChatsDto.class);
        return dto;
    }

}
