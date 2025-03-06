package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;

import java.util.List;
import java.util.Optional;

public interface CamaraService {

    List<Camara> findAll();

    Optional<Camara> findById(Integer id);

    Camara save(Camara camara);

    void deleteById(Integer id);

}
