package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Role;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Usuario;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.RoleRepository;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        Optional<Role> optionalRolUsuario = rolRepository.findByNombre("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRolUsuario.ifPresent(roles::add);

        if(usuario.isAdmin()){
            Optional<Role> optionalRolAdmin = rolRepository.findByNombre("ROLE_ADMIN");
            optionalRolAdmin.ifPresent(roles::add);
        }

        usuario.setRol(roles);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> update(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDb = usuarioOptional.orElseThrow();
            usuarioDb.setNombre(usuario.getNombre());
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

    @Override
    public boolean existsByUsername(String nombre) {
        return usuarioRepository.existsByNombre(nombre);
    }


}