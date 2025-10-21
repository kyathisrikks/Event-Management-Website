package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeddingController {
    @GetMapping("/wedding")
    public String showweddingpage() {
        return "/wedding";
    }

    @PostMapping("/bookwedding")
    public String bookweddingevent(@RequestParam String eventDate,
            @RequestParam(required = false) String wedding, Model model) {
        // TODO: process POST request

        model.addAttribute("eventDate", eventDate);
        model.addAttribute("wedding", wedding);

        return "forward:/book";
    }

}
