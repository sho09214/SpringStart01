package com.example.SpringStart01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {

    @GetMapping("/get-param")
    public String getParam(@RequestParam(name = "greeting") String greeting, Model model) {
        model.addAttribute("mGreeting", greeting);
        return "display";
    }
}
