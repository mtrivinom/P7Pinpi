package com.pinpilinpauxa.javateam.rest;


import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.model.User;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import com.pinpilinpauxa.javateam.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/platos")
public class PlatoRestController {

    @Autowired
    private PlatoService platoService;

    @GetMapping()
    public List<Plato> allPlatos(){ return platoService.obtenerPlatos();    }

    @PostMapping("/new")
    public Plato guardarPlato(@RequestBody Plato plato){
        return this.platoService.guardarPlato(plato);
    }

    @GetMapping("/{name}")
    public List<Plato> findByName(@PathVariable("name") String name) {
        return this.platoService.obtenerPorNombre(name);    }

    @GetMapping("/id/{id}")
    public Optional<Plato> findById(@PathVariable("id") Long id){
        return this.platoService.obtenerPorId(id);
    }

    @DeleteMapping("/id/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.platoService.eliminarPlato(id);
        if (ok){
            return "Se eliminó el plato con id " + id;
        }else{
            return "No se pudo eliminar el plato con id " + id;
        }
    }
    @PutMapping("/id/{id}")
    public Plato actualizarPlato(@PathVariable int id ,@RequestBody Plato plato) {
        return platoService.guardarPlato(plato);
    }
}
