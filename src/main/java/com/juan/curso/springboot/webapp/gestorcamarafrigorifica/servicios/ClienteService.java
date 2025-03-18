package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente save(Cliente cliente);

    Optional<Cliente> update(Integer id, Cliente cliente);

    Optional<Cliente> deleteById(Integer id);

}
