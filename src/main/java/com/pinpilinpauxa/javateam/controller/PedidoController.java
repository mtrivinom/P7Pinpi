package com.pinpilinpauxa.javateam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {
    @GetMapping("/pedido")
    String pedido() {
        return "pedido";
    }
}
