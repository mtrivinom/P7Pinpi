package com.pinpilinpauxa.javateam.service;

import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;
    public List<Plato> obtenerPlatos(){
        return (List<Plato>) platoRepository.findAll();
    }
    public Plato guardarPlato(Plato plato){
        return platoRepository.save(plato);
    }
    public Optional<Plato> obtenerPorId(Long id){
        return platoRepository.findById(id);
    }
    public List<Plato> obtenerPorNombre(String name) {
        return platoRepository.findByName(name);
    }
    public boolean eliminarPlato(Long id) {
        try{
            platoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
