package keno.SnsChats.security;

import keno.SnsChats.web.ChatsDto;
import keno.SnsChats.web.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FakeAuthEndpoint {
    /*@GetMapping("/fake/chats")
    public List<ChatsDto> fakeChats(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.sendError(401);
        }
        return List.of(ChatsDto.mockChatsDto());
    }*/

    @GetMapping("/fake/chats")
    public ResponseEntity<List<ChatsDto>> fakeChats(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.sendError(401);
        }
        return new ResponseEntity<>(List.of(ChatsDto.mockChatsDto()), HttpStatus.OK);
    }

    @PostMapping("/fake/register")
    public MemberDto register(@PathVariable(required = false) String name,
                              @PathVariable(required = false) String email,
                              @PathVariable(required = false) String password
    ) {
        return MemberDto.createMock();
    }

    @PostMapping("/fake")
    public ResponseEntity fakeHello() {
        return new ResponseEntity("Hello", HttpStatus.OK);
    }

    @PostMapping("/testlogin")
    public ResponseEntity testLoginEndpoint() {
        return new ResponseEntity(MemberDto.createMock(), HttpStatus.OK);
    }

}
