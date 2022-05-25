package keno.SnsChats.controller;

import keno.SnsChats.web.WeatherDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
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
}
