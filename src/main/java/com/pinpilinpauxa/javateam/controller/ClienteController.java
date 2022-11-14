package com.pinpilinpauxa.javateam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @GetMapping("/cliente")
    String cliente() {
        return "cliente";
    }
}
