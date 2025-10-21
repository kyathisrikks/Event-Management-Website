package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SangeetController {

    @GetMapping("/sangeet")
    public String showsangeetpage() {
        return "sangeet";
    }

    @PostMapping("/booksangeet")
    public String booksangeetevent(@RequestParam String eventDate,
            @RequestParam(required = false) String sangeet, Model model) {
        // TODO: process POST request
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("sangeet", sangeet);

        return "forward:/book";
    }

}
