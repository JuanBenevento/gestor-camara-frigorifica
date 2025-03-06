package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
