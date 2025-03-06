package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaleRepository extends JpaRepository<Pale, Integer> {
}
