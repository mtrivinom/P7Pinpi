package com.pinpilinpauxa.javateam.repository;

import com.pinpilinpauxa.javateam.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    public Long countById(Integer id);

}
