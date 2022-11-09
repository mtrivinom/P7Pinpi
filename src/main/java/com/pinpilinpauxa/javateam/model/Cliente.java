package com.pinpilinpauxa.javateam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_c;

    private String nombre_c;
    private String direccion_c;
    private String telefono_c;

    public Cliente() {

    }

    public Cliente(String nombre_c, String direccion_c, String telefono_c) {
        this.nombre_c = nombre_c;
        this.direccion_c = direccion_c;
        this.telefono_c = telefono_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getId_c() {
        return id_c;
    }

    public String getNombre_c() {
        return nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        this.nombre_c = nombre_c;
    }

    public String getDireccion_c() {
        return direccion_c;
    }

    public void setDireccion_c(String direccion_c) {
        this.direccion_c = direccion_c;
    }

    public String getTelefono_c() {
        return telefono_c;
    }

    public void setTelefono_c(String telefono_c) {
        this.telefono_c = telefono_c;
    }

}
