package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FacturaRepository extends JpaRepository<Factura, Integer> {
}
