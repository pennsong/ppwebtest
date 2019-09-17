package com.example.ppwebtest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MainController {
    @RequestMapping("**")
    public String test(@RequestBody String body) {
        System.out.println("received request" + LocalDateTime.now());
        System.out.println(body);
        return "ok";
    }
}
