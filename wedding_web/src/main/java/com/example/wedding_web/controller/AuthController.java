package com.example.wedding_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.wedding_web.Model.User;
import com.example.wedding_web.Service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please Login");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, RedirectAttributes redirectAttributes, HttpSession session) {
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            session.setAttribute("loggedInUser", authenticatedUser);
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password");
            return "redirect:/login";
        }

    }

    @GetMapping("/home")
    public String homepage() {
        return "/home";
    }

    // @GetMapping("/profile")
    // public String showProfilePage(HttpSession session,
    // RedirectAttributes redirectAttributes) {
    // User user = (User) session.getAttribute("loggedInUser");

    // if (user == null) {
    // redirectAttributes.addFlashAttribute("errorMessage", "Please login first!");
    // return "redirect:/login";
    // }

    // return "profile"; // This is the name of your profile.html page
    // }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("successMessage", "You have been logged out");
        return "redirect:/login";
    }

    @ModelAttribute
    public void addUserToModel(Model model, HttpSession session) {
        Object user = session.getAttribute("loggedInUser");
        if (user != null) {
            model.addAttribute("username", ((User) user).getUsername());
            model.addAttribute("email", ((User) user).getEmail());
        }
    }

}
