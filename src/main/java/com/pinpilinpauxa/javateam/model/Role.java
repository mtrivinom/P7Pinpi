package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
 //Añadimos la relación con la clase Usuario
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="rol_id")
        private Set<User> usuarios;
}
