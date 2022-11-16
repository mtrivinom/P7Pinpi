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

    @GetMapping("/plato/{id_p}")
    public Plato getPlatoById(@PathVariable(value = "id") Long id_p) {
        return platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));
    }

    @PutMapping("/plato/{id_p}")
    public Plato updatePlato(@PathVariable(value = "id") Long id_p, @RequestBody Plato platoDetails) {

        Plato plato = platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));

        plato.setNombre_p(platoDetails.getNombre_p());
        plato.setDescripcion(platoDetails.getDescripcion());
        plato.setKcal(platoDetails.getKcal());
        plato.setUnidades(platoDetails.getUnidades());
        plato.setTipo(platoDetails.getTipo());
        plato.setNombre_t(platoDetails.getNombre_t());

        Plato updatedPlato = platoRepository.save(plato);
        return updatedPlato;
    }

    @DeleteMapping("/plato/{id_p}")
    public ResponseEntity<?> deletePlato(@PathVariable(value = "id") Long id_p) {
        Plato plato = platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));

        platoRepository.delete(plato);

        return ResponseEntity.ok().build();
    }
}
