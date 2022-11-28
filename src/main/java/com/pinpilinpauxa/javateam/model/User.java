package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "usuario", nullable = false, length = 20)
    private String usuario;
    @Email
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public User(Long id, String email, String password, String nombre, String usuario) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public User(String email, String password, String nombre, String usuario) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public User() {
    }

    


}