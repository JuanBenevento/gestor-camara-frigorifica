package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> findAll();

    Optional<Factura> findById(Integer id);

    Factura save(Factura factura);

    Optional<Factura> update(Integer id, Factura factura);

    Optional<Factura> deleteById(Integer id);

}
