package com.pinpilinpauxa.javateam.rest;

import com.pinpilinpauxa.javateam.model.User;
import com.pinpilinpauxa.javateam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository repository;

    @GetMapping("")
    public List<User> allPersons(){
        return repository.findAll();
    }

    @GetMapping("/{nombre}")
    public List<User> findByNombre(@PathVariable("nombre") String nombre) {
        return repository.findByNombre(nombre);
    }

    @PostMapping("/new")
    public User createPerson(@RequestBody User person) {
        return repository.save(person);
    }

    @PutMapping("/{id}")
    public User updatePerson(@PathVariable int id ,@RequestBody User person) {
        return repository.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}
