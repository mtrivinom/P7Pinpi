package com.pinpilinpauxa.javateam.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id_p;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User usuario;


/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "menus_pedidos",
        joinColumns = @JoinColumn(name = "id_menu", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_pedido", nullable = false)
    )
   private Set<Menu> menus;
*/
    public Long getId_p() {
        return id_p;
    }
    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido() {
    }
}
