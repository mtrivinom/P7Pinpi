package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public enum Role {
    USER,
    ADMIN;
}



/*
@Entity
@Table(name = "rol")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;

 //Añadimos la relación con la clase Usuario
  /*      @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name="lista_users")
        private Set<User> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    public Set<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<User> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUser (User usuario){
            if (null == usuarios) {
                usuarios = new HashSet<>();
            }
            usuarios.add(usuario);
            usuario.setRol(this);
        }
        public void removeComment(User usuario) {
            usuarios.remove(usuario);
            usuario.setRol(null);
        }
*/



/*

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Role(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Role() {

    }

    public Role(String nombre) {
        super();
        this.nombre = nombre;
    }


}*/

