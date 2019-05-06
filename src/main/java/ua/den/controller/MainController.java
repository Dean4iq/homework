package ua.den.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping("/login")
    public String getLoginPage(Principal principal) {
        return (principal == null) ? "login.html" : "redirect:/home";
    }

    @RequestMapping("/register")
    public String getRegisterPage(Principal principal) {
        return (principal == null) ? "registration.html" : "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "homepage.html";
    }
}
