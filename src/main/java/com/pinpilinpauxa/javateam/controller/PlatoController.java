package com.pinpilinpauxa.javateam.controller;

import com.pinpilinpauxa.javateam.exception.ResourceNotFoundException;
import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    public String save(Plato plato, SessionStatus status) {
        platoRepository.save(plato);
        status.setComplete();
        return "redirect:plato";
    }

    @GetMapping("/plato/{id}")
    public Plato getPlatoById(@PathVariable(value = "id") Long id) {
        return platoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id));
    }

    @PutMapping("/plato/{id}")
    public Plato updatePlato(@PathVariable(value = "id") Long id, @RequestBody Plato platoDetails) {

        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id));

        plato.setNombre_p(platoDetails.getNombre_p());
        plato.setDescripcion(platoDetails.getDescripcion());
        plato.setKcal(platoDetails.getKcal());
        plato.setUnidades(platoDetails.getUnidades());
        plato.setTipo(platoDetails.getTipo());
        plato.setNombre_t(platoDetails.getNombre_t());

        Plato updatedPlato = platoRepository.save(plato);
        return updatedPlato;
    }

    @DeleteMapping("/plato/{id}")
    public ResponseEntity<?> deletePlato(@PathVariable(value = "id") Long id) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id));

        platoRepository.delete(plato);

        return ResponseEntity.ok().build();
    }
}
