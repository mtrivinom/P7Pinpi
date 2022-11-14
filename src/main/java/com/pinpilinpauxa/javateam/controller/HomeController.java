package com.pinpilinpauxa.javateam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String greeting() {
        return "Hello World from Spring Boot with Pinpilinpauxa";
    }

    @RequestMapping("/goodbye")
    public String goodbye(){
        return "Goodbye! See you in the next product :)";
    }
}