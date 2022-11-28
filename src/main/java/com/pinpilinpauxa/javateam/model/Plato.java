package com.pinpilinpauxa.javateam.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "plato")
@EntityListeners(AuditingEntityListener.class)
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_p;

    @NotEmpty
    private String nombre_p;

    @NotEmpty
    private String descripcion;
    private int kcal;
    private int unidades;

    @NotEmpty
    private String tipo;

    public Long getId_p() {
        return id_p;
    }
    public void setId_p(Long id_p) {
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

}
