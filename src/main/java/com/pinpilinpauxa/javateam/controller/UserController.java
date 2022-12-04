package com.pinpilinpauxa.javateam.controller;

import com.pinpilinpauxa.javateam.model.CustomUserDetails;
import com.pinpilinpauxa.javateam.model.Role;
import com.pinpilinpauxa.javateam.model.User;
import com.pinpilinpauxa.javateam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register_form";
    }

    @GetMapping("/register_admin")
    public String showRegistrationFormAdmin(Model model) {
        model.addAttribute("user", new User());

        return "register_form_admin";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         // assign Role USER to newly registered user
        user.setRol(Collections.singleton(Role.USER));
       userRepository.save(user);
       return "register_success";
    }

    @PostMapping("/process_register_admin")
    public String processRegisterAdmin(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        // assign Role USER to newly registered user
        user.setRol(Collections.singleton(Role.ADMIN));
       // user.setRol(Role.ADMIN);
        userRepository.save(user);

        return "register_success";
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }


        return new CustomUserDetails(user);
    }
   /* @GetMapping("/prueba01")
    public String mostrarUsuario (Authentication auth){
        String userName = auth.getName();

        System.out.println("Usuario: "+ userName);

        for (GrantedAuthority rol: auth.getAuthorities()){

            System.out.println("ROL: " + rol.getAuthority());
        }

        return userName;


    }*/


}
