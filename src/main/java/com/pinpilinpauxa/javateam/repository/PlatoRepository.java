package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    public List<Plato> findAll();

    public Plato save(Plato plato);

}