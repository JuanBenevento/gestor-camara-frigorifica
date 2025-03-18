package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.FacturaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Factura> getById(@PathVariable Integer id) {
        Optional<Factura> factura = facturaService.findById(id);
        if (factura.isPresent()) {
            return ResponseEntity.ok(factura.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Factura> create(@RequestBody Factura factura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable Integer id, @Valid @RequestBody Factura factura) {
        Optional<Factura> facturaOptional = facturaService.update(id, factura);
        if (facturaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(facturaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Factura> facturaOptional = facturaService.deleteById(id);
        if (facturaOptional.isPresent()) {
            return ResponseEntity.ok(facturaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


}
