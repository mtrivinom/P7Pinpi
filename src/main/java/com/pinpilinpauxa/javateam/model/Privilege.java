package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String admin;
    private String email;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

}
