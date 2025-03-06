package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.OrdenCarga;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.OrdenCargaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes-carga")
public class OrdenCargaController {
    @Autowired
    private OrdenCargaServiceImpl ordenCargaService;

    @GetMapping
    public List<OrdenCarga> getAll() { return ordenCargaService.findAll(); }

    @GetMapping("/{id}")
    public Optional<OrdenCarga> getById(@PathVariable Integer id) { return ordenCargaService.findById(id); }

    @PostMapping
    public OrdenCarga create(@RequestBody OrdenCarga ordenCarga) { return ordenCargaService.save(ordenCarga); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { ordenCargaService.deleteById(id); }
}
