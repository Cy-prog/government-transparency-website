package io.github.cyprog.government_transparency_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "home";  // This serves home.html for root "/"
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";  // This serves home.html for "/home"
    }
}

