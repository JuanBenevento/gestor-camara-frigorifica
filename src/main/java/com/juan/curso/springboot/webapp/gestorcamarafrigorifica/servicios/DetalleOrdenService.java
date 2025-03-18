package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.DetalleOrden;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenService {
    List<DetalleOrden> findAll();

    Optional<DetalleOrden> findById(Integer id);

    DetalleOrden save(DetalleOrden detalleOrden);

    Optional<DetalleOrden> update(Integer id, DetalleOrden detalleOrden);

    Optional<DetalleOrden> deleteById(Integer id);
}
