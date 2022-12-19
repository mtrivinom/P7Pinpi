package com.pinpilinpauxa.javateam.rest;

import com.pinpilinpauxa.javateam.model.User;
import com.pinpilinpauxa.javateam.repository.UserRepository;
import com.pinpilinpauxa.javateam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> allPersons(){return userService.obtenerUsers();}

    @GetMapping("/{nombre}")
    public List<User> findByNombre(@PathVariable("nombre") String nombre) {
        return userService.obtenerPorNombre(nombre);
    }

    @PostMapping("/new")
    public User createPerson(@RequestBody User person) {
        return userService.guardarUser(person);
    }

    @PutMapping("/{id}")
    public User updatePerson(@PathVariable int id ,@RequestBody User person) {
        return userService.guardarUser(person);
    }

   @DeleteMapping("/{id}")
   public String eliminarUserPorId(@PathVariable("id") Long id){
       boolean ok = userService.eliminarUser(id);
       if (ok){
            return "Se eliminó el usuario con id " + id;
       }else{
            return "No pudo eliminar el usuario con id " + id;
       }
   }
}
