package com.pinpilinpauxa.javateam.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User /*implements UserDetails */{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Email
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

 /*
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "rol", nullable=false)
    private Role rol;
*/

// user roles

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> rol;

/*
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
    )
    private Collection<Role> roles;

 */



    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }*/
    /*
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRol() {
        return rol;
    }

    public void setRol(Set<Role> rol) {
        this.rol = rol;
    }
/*
    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
*/
    /*
    public User(Long id, String email, String password, String nombre, String usuario) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public User(String email, String password, String nombre, String usuario) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.usuario = usuario;
    }*/

    public User() {
    }
    // if user is admin

   /*
    public boolean isAdmin() {
        return rol.contains(Role.ADMIN);
    }
    // Getter and setter for user roles
    public Set<Role> getRoles() {
        return rol;
    }

    public void setRoles(Set<Role> roles) {
        this.rol = roles;
    }

@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.toString()));
        return roles;
    }

    public User(Long id, String nombre, String usuario, String email, String password, Set<Role> rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }*/
    /*
@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.toString()));
        return roles;
    }

    public User(Long id, String nombre, String usuario, String email, String password, Role rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }*/
/*
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public User(Long id, String nombre, String usuario, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String nombre, String usuario, String email, String password, Collection<Role> roles) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }*/

    public User(String nombre, String username, String email, String password, Set<Role> rol) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public User(String nombre, String username, String email, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}