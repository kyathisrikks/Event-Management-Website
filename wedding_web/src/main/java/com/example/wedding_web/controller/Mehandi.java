package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mehandi {
    @GetMapping("/mehandi")
    public String showmehandipage() {
        return "mehandi";
    }

    @PostMapping("/bookmehandi")
    public String bookmehandievent(@RequestParam String eventDate,
            @RequestParam(required = false) String mehandi, Model model) {
        // TODO: process POST request

        model.addAttribute("eventDate", eventDate);
        model.addAttribute("mehandi", mehandi);

        return "forward:/book";
    }

}
