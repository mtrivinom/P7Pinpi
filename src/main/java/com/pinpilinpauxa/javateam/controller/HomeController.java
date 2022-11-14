package com.pinpilinpauxa.javateam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/menu")
    String menu() {
        return "menu";
    }

    @GetMapping("/pedido")
    String pedido() {
        return "pedido";
    }

    @GetMapping("/cliente")
    String cliente() {
        return "cliente";
    }

    @GetMapping("/plato")
    String plato() {
        return "plato";
    }
}