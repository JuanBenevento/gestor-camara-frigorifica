package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Producto;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.ProductoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @Valid @RequestBody Producto producto) {
        Optional<Producto> facturaOptional = productoService.update(id, producto);
        if (facturaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(facturaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Producto> productoOptional = productoService.deleteById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
