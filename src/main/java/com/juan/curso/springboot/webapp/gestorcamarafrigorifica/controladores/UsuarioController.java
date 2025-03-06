package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Usuario;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public List<Usuario> getAll() { return usuarioService.findAll(); }

    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Integer id) { return usuarioService.findById(id); }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) { return usuarioService.save(usuario); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { usuarioService.deleteById(id); }
}
