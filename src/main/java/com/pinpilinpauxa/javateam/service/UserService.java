package com.pinpilinpauxa.javateam.service;

import com.pinpilinpauxa.javateam.model.User;
import com.pinpilinpauxa.javateam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> obtenerUsers(){
        return (List<User>) userRepository.findAll();
    }
    public List<User> obtenerPorNombre(@PathVariable("nombre") String nombre) {
        return userRepository.findByNombre(nombre);
    }
    public User guardarUser(User user){
        return userRepository.save(user);
    }
    public boolean eliminarUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
