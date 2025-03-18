package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Usuario;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> update(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDb = usuarioOptional.orElseThrow();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setRol(usuario.getRol());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return Optional.of(usuarioRepository.save(usuarioDb));
        }
        return usuarioOptional;
    }

    @Transactional
    @Override
    public Optional<Usuario> deleteById(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        usuarioOptional.ifPresent(usuarioDb -> {
            usuarioRepository.delete(usuarioDb);
        });
        return usuarioOptional;
    }
}