package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    Usuario save(Usuario usuario);

    Optional<Usuario> update(Integer id, Usuario usuario);

    Optional<Usuario> deleteById(Integer id);
}
