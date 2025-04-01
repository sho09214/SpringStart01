package com.example.SpringStart01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeSpringController {
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome-spring";
    }
}
