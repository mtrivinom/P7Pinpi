package com.pinpilinpauxa.javateam.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "plato")
@EntityListeners(AuditingEntityListener.class)
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_p;

    private String nombre_p;
    private String descripcion;
    private int kcal;
    private int unidades;
    private String tipo;
    private String nombre_t;

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre_t() {
        return nombre_t;
    }

    public void setNombre_t(String nombre_t) {
        this.nombre_t = nombre_t;
    }

}
