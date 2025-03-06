package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;

import java.util.List;
import java.util.Optional;

public interface PaleService {
    List<Pale> findAll();

    Optional<Pale> findById(Integer id);

    Pale save(Pale pale);

    void deleteById(Integer id);
}
