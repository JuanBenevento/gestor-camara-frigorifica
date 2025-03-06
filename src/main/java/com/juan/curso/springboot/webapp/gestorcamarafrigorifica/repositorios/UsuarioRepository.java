package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
