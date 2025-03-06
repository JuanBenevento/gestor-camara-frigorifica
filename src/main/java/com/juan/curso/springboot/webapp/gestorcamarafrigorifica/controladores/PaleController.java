package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.PaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pale")
public class PaleController {
    @Autowired
    private PaleService paleService;

    @GetMapping
    public List<Pale> getAll() { return paleService.findAll(); }

    @GetMapping("/{id}")
    public Optional<Pale> getById(@PathVariable Integer id) { return paleService.findById(id); }

    @PostMapping
    public Pale create(@RequestBody Pale pale) { return paleService.save(pale); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { paleService.deleteById(id); }

}
