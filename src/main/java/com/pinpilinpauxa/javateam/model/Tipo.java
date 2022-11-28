package com.pinpilinpauxa.javateam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_t;
    private String nombre_t;

    public int getId_t() {
        return id_t;
    }
    public void setId_t(int id_t) {
        this.id_t = id_t;
    }
    public String getNombre_t() {
        return nombre_t;
    }
    public void setNombre_t(String nombre_t) {
        this.nombre_t = nombre_t;
    }

}
