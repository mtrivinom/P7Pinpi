package com.pinpilinpauxa.javateam.service;

import com.pinpilinpauxa.javateam.model.Cliente;
import com.pinpilinpauxa.javateam.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired private ClienteRepository clienteRepository;

    public List<Cliente> listAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public String save(Cliente cliente) {
        clienteRepository.save(cliente);

        return "redirect:/cliente";
    }

    public Cliente get(Integer id) throws UserNotFoundException {
        Optional<Cliente> result = clienteRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("The user has been saved successfully.");
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = clienteRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find the Customer.");
        }
        clienteRepository.deleteById(id);
    }
}
