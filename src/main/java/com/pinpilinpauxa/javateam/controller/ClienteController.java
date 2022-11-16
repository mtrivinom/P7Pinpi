package com.pinpilinpauxa.javateam.controller;

import com.pinpilinpauxa.javateam.model.Cliente;
import com.pinpilinpauxa.javateam.service.ClienteService;
import com.pinpilinpauxa.javateam.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired private ClienteService clienteService;

    @GetMapping("/cliente")
    public String showUserList(Model model) {

        List<Cliente> listClients = clienteService.listAll();
        model.addAttribute("listClients", listClients);

        return "cliente";
    }

    @GetMapping("/client/new")
    public String showNewForm(Model model) {
        model.addAttribute("client", new Cliente());
        return "client_form";
    }

    @PostMapping("/client/save")
    public String saveClient(Cliente cliente) {
        clienteService.save(cliente);

        return "redirect:/cliente";
    }

    @GetMapping("/client/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Cliente cliente = clienteService.get(id);
            model.addAttribute("client", cliente);
            return "client_form";

        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/cliente";
        }

    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            clienteService.delete(id);
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/cliente";
    }

}
