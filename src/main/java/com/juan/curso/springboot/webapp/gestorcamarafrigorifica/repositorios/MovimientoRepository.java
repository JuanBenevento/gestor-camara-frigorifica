package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
