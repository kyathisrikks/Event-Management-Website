package com.example.wedding_web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Cuisinecontroller {
    @GetMapping("/cuisine")
    public String showcuisinepage() {
        return "cuisine";
    }

    @PostMapping("/bookcuisine")
    public String bookcuisinecourse(@RequestParam String eventDate,
            @RequestParam(required = false) List<String> vegItems,
            @RequestParam(required = false) List<String> nonVegItems,
            Model model) {

        // String vegList = (vegItems != null) ? String.join(", ", vegItems) : "";
        // String nonVegList = (nonVegItems != null) ? String.join(", ", nonVegItems) :
        // "";

        // TODO: process POST request

        model.addAttribute("eventDate", eventDate);
        model.addAttribute("vegItems", vegItems);
        model.addAttribute("nonVegItems", nonVegItems);
        // model.addAttribute("menuType", menuType);
        return "forward:/book";
    }

}
