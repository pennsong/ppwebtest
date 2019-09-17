package com.example.ppwebtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MainController {
    @RequestMapping("**")
    public String test() {
        System.out.println("received request" + LocalDateTime.now());
        return "ok";
    }
}
