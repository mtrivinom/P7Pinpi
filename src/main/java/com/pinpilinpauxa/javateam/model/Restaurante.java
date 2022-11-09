package com.pinpilinpauxa.javateam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_r;
    private String nombre_r;
    private String direccion_r;
    private String telefono_r;


    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    public String getNombre_r() {
        return nombre_r;
    }

    public void setNombre_r(String nombre_r) {
        this.nombre_r = nombre_r;
    }

    public String getDireccion_r() {
        return direccion_r;
    }

    public void setDireccion_r(String direccion_r) {
        this.direccion_r = direccion_r;
    }

    public String getTelefono_r() {
        return telefono_r;
    }

    public void setTelefono_r(String telefono_r) {
        this.telefono_r = telefono_r;
    }

}
