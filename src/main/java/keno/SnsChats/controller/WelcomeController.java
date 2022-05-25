package keno.SnsChats.controller;

import com.sun.net.httpserver.HttpsServer;
import keno.SnsChats.security.CurrentMember;
import keno.SnsChats.web.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WelcomeController {
    private final CurrentMember currentMember;
    @GetMapping("/hello")
    public ResponseEntity hello() {
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

    @GetMapping("/hellobuddy")
    public ResponseEntity hellobuddy() {
        return new ResponseEntity("Ok Man!", HttpStatus.OK);
    }

    @GetMapping("/weather")
    public ResponseEntity weather() {
        return new ResponseEntity(WeatherDto.createMock(), HttpStatus.OK);
    }

    @GetMapping("/whoami")
    public ResponseEntity whoAmI() {
        return new ResponseEntity(currentMember.id(), HttpStatus.OK);
    }
}
