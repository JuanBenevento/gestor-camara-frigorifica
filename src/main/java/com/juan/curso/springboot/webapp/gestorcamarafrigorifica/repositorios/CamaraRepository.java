package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CamaraRepository extends JpaRepository<Camara, Integer> {
}
