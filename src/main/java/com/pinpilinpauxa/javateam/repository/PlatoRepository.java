package com.pinpilinpauxa.javateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinpilinpauxa.javateam.model.Plato;

import java.util.List;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    public List<Plato> findAll();

    public Plato save(Plato plato);
}