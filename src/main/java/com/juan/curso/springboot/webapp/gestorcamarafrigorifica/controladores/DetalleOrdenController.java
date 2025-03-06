package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.DetalleOrden;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.DetalleOrdenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-orden")
public class DetalleOrdenController {
    @Autowired
    private DetalleOrdenServiceImpl detalleOrdenService;

    @GetMapping
    public List<DetalleOrden> getAll() { return detalleOrdenService.findAll(); }

    @GetMapping("/{id}")
    public Optional<DetalleOrden> getById(@PathVariable Integer id) { return detalleOrdenService.findById(id); }

    @PostMapping
    public DetalleOrden create(@RequestBody DetalleOrden detalleOrden) { return detalleOrdenService.save(detalleOrden); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) { detalleOrdenService.deleteById(id); }

}
