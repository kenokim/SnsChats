package keno.SnsChats.controller;

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
}
