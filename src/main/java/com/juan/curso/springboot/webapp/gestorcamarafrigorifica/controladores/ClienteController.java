package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public List<Cliente> getAll() { return clienteService.findAll(); }

    @GetMapping("/{id}")
    public Optional<Cliente> getById(@PathVariable Integer id) { return clienteService.findById(id); }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) { return clienteService.save(cliente); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { clienteService.deleteById(id); }
}
