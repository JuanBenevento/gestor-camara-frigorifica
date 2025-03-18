package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.OrdenCarga;

import java.util.List;
import java.util.Optional;

public interface OrdenCargaService {
    List<OrdenCarga> findAll();

    Optional<OrdenCarga> findById(Integer id);

    OrdenCarga save(OrdenCarga ordenCarga);

    Optional<OrdenCarga> update(Integer id, OrdenCarga ordenCarga);

    Optional<OrdenCarga> deleteById(Integer id);

}
