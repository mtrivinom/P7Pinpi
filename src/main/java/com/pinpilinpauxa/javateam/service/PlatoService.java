package com.pinpilinpauxa.javateam.service;

import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public Plato get(Long id_p) throws UserNotFoundException {
        Optional<Plato> result = platoRepository.findById(id_p);

        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("The user has been saved successfully.");
    }
}
