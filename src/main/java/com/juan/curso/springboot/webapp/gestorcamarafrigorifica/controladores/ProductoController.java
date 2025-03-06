package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Producto;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public List<Producto> getAll() { return productoService.findAll(); }

    @GetMapping("/{id}")
    public Optional<Producto> getById(@PathVariable Integer id) { return productoService.findById(id); }

    @PostMapping
    public Producto create(@RequestBody Producto producto) { return productoService.save(producto); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { productoService.deleteById(id); }
}
