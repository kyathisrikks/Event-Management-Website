package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EngagementController {

    @GetMapping("/engagement")
    public String showengagementpage() {
        return "engagement";
    }

    @PostMapping("/bookengagement")
    public String bookEvent(@RequestParam String eventDate,
            @RequestParam(value = "decor", required = false) String decor,
            @RequestParam(value = "cake", required = false) String cake, Model model) {
        // TODO: process POST request
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("decor", decor);
        model.addAttribute("cake", cake);
        return "forward:/book";
    }

}