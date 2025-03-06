package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.OrdenCarga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCargaRepository extends JpaRepository<OrdenCarga, Integer> {
}
