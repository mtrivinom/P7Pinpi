package com.pinpilinpauxa.javateam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plato {

    @Id_p
    @GeneratedValue(strategy=GenerationType.AUTO)

    private int id_p;
    private String nombre_p;
    private String descripcion;
    private int kcal;
    private int unidades;
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

    public String getNombre_t() {
        return nombre_t;
    }

    public void setNombre_t(String nombre_t) {
        this.nombre_t = nombre_t;
    }

}

@Entity
public class Tipo {

    @Id_t
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

@Entity
public class Menu {

    @Id_m
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_m;
    private double precio;

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

@Entity
public class Restaurante {

    @Id_r
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

@Entity
public class Cliente {

    @Id_c
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_c;
    private String nombre_c;
    private String direccion_c;
    private String telefono_c;

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
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

@Entity
public class Eleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_m;
    private int id_p;

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

}

@Entity
public class Eleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_m;
    private int id_p;

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

}

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_m;
    private int id_c;

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

}



