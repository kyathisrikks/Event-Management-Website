package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReceptionController {
    @GetMapping("/reception")
    public String showreceptionpage() {
        return "reception";
    }

    @PostMapping("/bookreception")
    public String bookreceptionevent(@RequestParam String eventDate,
            @RequestParam(required = false) String reception, Model model) {
        // TODO: process POST request

        model.addAttribute("eventDate", eventDate);
        model.addAttribute("reception", reception);

        return "forward:/book";
    }

}
