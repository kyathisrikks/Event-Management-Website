package com.example.wedding_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// import org.springframework.ui.Model;
import org.springframework.ui.Model;

@Controller
public class HaldiController {

    @GetMapping("/haldi")
    public String showhaldipage() {
        return "haldi";
    }

    @PostMapping("/bookhaldi")
    public String bookhaldievent(@RequestParam String eventDate,
            @RequestParam(required = false) String floral,
            @RequestParam(required = false) String flowerset, Model model) {
        // TODO: process POST request
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("floral", floral);
        model.addAttribute("flowerset", flowerset);

        return "forward:/book";
    }

}
