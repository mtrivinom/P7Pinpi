package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_m;
    private double precio;
/*
    @ManyToMany(mappedBy = "menus")
    private Set<Pedido> pedidos;
*/

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
