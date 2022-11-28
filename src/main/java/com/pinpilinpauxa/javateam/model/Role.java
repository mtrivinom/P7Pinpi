package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String admin;
    private String email;

    @ManyToMany(mappedBy = "roles")
    private Collection<Admin> users;

    private Collection<Privilege> privileges;
}
