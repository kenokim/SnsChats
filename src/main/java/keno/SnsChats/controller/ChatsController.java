package keno.SnsChats.controller;

import keno.SnsChats.domain.Chats;
import keno.SnsChats.security.CurrentMember;
import keno.SnsChats.service.ChatsService;
import keno.SnsChats.web.ChatsCreateDto;
import keno.SnsChats.web.ChatsDetailsDto;
import keno.SnsChats.web.ChatsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatsController {

    private final ChatsService chatsService;
    private final CurrentMember currentMember;

    private final ModelMapper modelMapper;

    /*
    @GetMapping
    public List<ChatsDto> findAllChats(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.sendError(401);
        }
        return chatsService.findAll().stream().map(c -> convertToDto(c)).collect(Collectors.toList());
    }
*/

    @GetMapping
    public List<ChatsDto> findAllChats(@RequestParam(required = false) Integer pageNum) throws IOException {
        return chatsService.findAll().stream().map(c -> convertToDto(c)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity createChats() {
        chatsService.create("Hello " + LocalDateTime.now().toString(), 10, currentMember.id());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{chatsId}")
    public ChatsDetailsDto findChatsById(@PathVariable("chatsId") Long chatsId) {
        //return convertToDto(chatsService.findChatsById(chatsId));
        return ChatsDetailsDto.createMock();
    }

    /*@PostMapping
    public ResponseEntity createChats(ChatsCreateDto dto) {
        chatsService.create(dto.getTitle(), dto.getMaxNumMembers(), currentMember.id());
        return new ResponseEntity(HttpStatus.OK);
    }*/

    private ChatsDto convertToDto(Chats chats) {
        ChatsDto dto = modelMapper.map(chats, ChatsDto.class);
        return dto;
    }

    /*private ChatsDetailsDto convertToDto(ChatsDetails chatsDetails) {
        ChatsDetailsDto dto = modelMapper.map(chatsDetails, ChatsDetailsDto.class);
        return dto;
    }*/

}
