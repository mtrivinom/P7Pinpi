package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Plato;
import com.pinpilinpauxa.javateam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    //public List<Plato> findAll();

    public abstract List<Plato> findByName(String name);


    //public Plato save(Plato plato);

}
