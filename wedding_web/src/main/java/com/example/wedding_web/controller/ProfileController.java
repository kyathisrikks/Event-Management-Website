package com.example.wedding_web.controller;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.wedding_web.Model.User;
import com.example.wedding_web.Model.Booking;

import com.example.wedding_web.Repository.BookingRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<Booking> bookings = bookingRepository.findAllByUser(loggedInUser);

        model.addAttribute("bookings", bookings);

        return "profile";
    }

}
