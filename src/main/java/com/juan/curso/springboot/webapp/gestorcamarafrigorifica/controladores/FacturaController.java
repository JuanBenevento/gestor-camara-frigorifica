package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    private FacturaServiceImpl facturaService;

    @GetMapping
    public List<Factura> getAll() { return facturaService.findAll(); }

    @GetMapping("/{id}")
    public Optional<Factura> getById(@PathVariable Integer id) { return facturaService.findById(id); }

    @PostMapping
    public Factura create(@RequestBody Factura factura) { return facturaService.save(factura); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { facturaService.deleteById(id); }
}
