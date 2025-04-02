package com.example.SpringStart01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeMvcController {

    @GetMapping("/welcome-m")
    public String welcomeM(Model model) {
        model.addAttribute("greeting", "Hello");
        model.addAttribute("welcome", "Welcome MVC (Model)");

        return "welcome-mvc";
    }

    @GetMapping("/welcome-mv")
    public ModelAndView welcomeMv(ModelAndView mv) {
        mv.addObject("greeting", "Hello");
        mv.addObject("welcome", "Welcome MVC (ModelAndView)");
        mv.setViewName("welcome-mvc");

        return mv;
    }
}
