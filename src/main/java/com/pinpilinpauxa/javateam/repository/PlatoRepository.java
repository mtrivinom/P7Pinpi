package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlatoRepository extends CrudRepository<Plato, Long> {

    public List<Plato> findAll();

    public Plato save(Plato plato);

}