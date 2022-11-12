package com.pinpilinpauxa.javateam.controller;

import com.pinpilinpauxa.javateam.exception.ResourceNotFoundException;
import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {

    @Autowired
    PlatoRepository platoRepository;

    @GetMapping("/plato")
    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    @PostMapping("/plato")
    public Plato createPlato(@RequestBody Plato plato) {
        return platoRepository.save(plato);
    }

    @GetMapping("/plato/{id}")
    public Plato getPlatoById(@PathVariable(value = "id") Long id_p) {
        return platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));
    }

    @PutMapping("/plato/{id}")
    public Plato updatePlato(@PathVariable(value = "id") Long id_p, @RequestBody Plato platoDetails) {

        Plato plato = platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));

        plato.setNombre_p(platoDetails.getNombre_p());
        plato.setDescripcion(platoDetails.getDescripcion());
        plato.setKcal(platoDetails.getKcal());
        plato.setUnidades(platoDetails.getUnidades());
        plato.setNombre_t(platoDetails.getNombre_t());

        Plato updatedPlato = platoRepository.save(plato);
        return updatedPlato;
    }

    @DeleteMapping("/plato/{id}")
    public ResponseEntity<?> deletePlato(@PathVariable(value = "id") Long id_p) {
        Plato plato = platoRepository.findById(id_p)
                .orElseThrow(() -> new ResourceNotFoundException("Plato", "id", id_p));

        platoRepository.delete(plato);

        return ResponseEntity.ok().build();
    }
}
