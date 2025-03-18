package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {
    List<Movimiento> findAll();

    Optional<Movimiento> findById(Integer id);

    Movimiento save(Movimiento movimiento);

    Optional<Movimiento> update(Integer id, Movimiento movimiento);

    Optional<Movimiento> deleteById(Integer id);
}
