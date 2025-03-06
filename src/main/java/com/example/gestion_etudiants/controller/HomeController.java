package com.example.gestion_etudiants.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Bienvenue sur l'application de gestion des étudiants 🚀";
    }
}
