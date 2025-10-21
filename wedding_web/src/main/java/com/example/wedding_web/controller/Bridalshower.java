package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bridalshower {

    @GetMapping("/bridalshower")
    public String showbridalshowerpage() {
        return "bridalshower";
    }

    @PostMapping("/bookbridalshower")
    public String bookbridalshoweevent(@RequestParam String eventDate,
            @RequestParam(required = false) String bridalshower, Model model) {
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("bridalshower", bridalshower);

        return "forward:/book";
    }

}
