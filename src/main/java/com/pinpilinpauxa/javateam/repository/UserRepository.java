package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
/*
   @Query("SELECT u FROM User u WHERE u.nombre = ?1")
    public List<User> findByName(String name);*/

    List<User> findByNombre(@Param("nombre") String nombre);

}