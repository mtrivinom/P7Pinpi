package com.pinpilinpauxa.javateam.controller;

import com.pinpilinpauxa.javateam.exception.ResourceNotFoundException;
import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
public class PlatoController {
    @Autowired
    PlatoRepository platoRepository;

    @GetMapping("/plato")
    public ModelAndView getAllPlatos() {
        ModelAndView mav = new ModelAndView("plato");
        mav.addObject("dishes", platoRepository.findAll());
        return mav;
    }

    @RequestMapping(value="/createDishForm")
    public String createPlato(Map<String, Object> model) {
        Plato plato = new Plato();
        model.put("plato", plato);
        return "createDishForm";
    }

    @RequestMapping(value="/createDishForm", method=RequestMethod.POST)
    public String save(@Valid @ModelAttribute("plato") Plato plato, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "createDishForm";
        }
        platoRepository.save(plato);
        status.setComplete();
        return "redirect:plato";
    }

    @GetMapping("/plato/{id_p}")
    public Plato getPlatoById(@PathVariable(value = "id") Long id_p) {
        return platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));
    }

    @GetMapping("/dish/edit/{id_p}")
    public String showEditForm(@PathVariable("id_p") Long id_p, Model model, RedirectAttributes redirectAttributes) {
        Optional<Plato> plato = platoRepository.findById(id_p);
        model.addAttribute("plato", plato);
        return "createDishForm";

    }

    @GetMapping("/deleteDish")
    public String deleteDish(@RequestParam Long dishId) {
        System.out.println(dishId);
        Plato plato = platoRepository.findById(dishId)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", dishId));
        platoRepository.delete(plato);
        return "redirect:/plato";
    }
}
