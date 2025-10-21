package com.example.wedding_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_web.Model.Booking;
import com.example.wedding_web.Model.User;
// import com.example.wedding_web.Repository.BookingRepository;
import com.example.wedding_web.Service.BookingService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import java.util.List;
// import java.security.Principal;
import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // @Autowired
    // private BookingRepository bookingRepository;

    @PostMapping("/book")
    public String bookEvent(@RequestParam Map<String, String> params,
            @RequestParam(required = false) List<String> vegItems,
            @RequestParam(required = false) List<String> nonVegItems,
            Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }

        String vegList = (vegItems != null) ? String.join(", ", vegItems) : "";
        String nonVegList = (nonVegItems != null) ? String.join(", ", nonVegItems) : "";

        params.put("vegItems", vegList);
        params.put("nonVegItems", nonVegList);

        Booking booking = bookingService.createBooking(params, user);

        model.addAttribute("eventDate", booking.getEventDate());
        model.addAttribute("decor", booking.getDecor());
        model.addAttribute("cake", booking.getCake());
        model.addAttribute("floral", booking.getFloral());
        model.addAttribute("flowerset", booking.getFlowerset());
        model.addAttribute("sangeet", booking.getSangeet());
        model.addAttribute("bridalshower", booking.getBridalshower());
        model.addAttribute("mehandi", booking.getMehandi());
        model.addAttribute("wedding", booking.getWedding());
        model.addAttribute("reception", booking.getReception());
        model.addAttribute("vegItems", vegList);
        model.addAttribute("nonVegItems", nonVegList);

        return "thankyou";
    }
}
