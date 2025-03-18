package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.MovimientoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoServiceImpl movimientoService;

    @GetMapping
    public List<Movimiento> getAll() { return movimientoService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getById(@PathVariable Integer id) {
        Optional<Movimiento> movimiento = movimientoService.findById(id);
        if (movimiento.isPresent()) {
            return ResponseEntity.ok(movimiento.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Movimiento> create(@RequestBody Movimiento movimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Movimiento movimiento) {
        Optional<Movimiento> movimientoOptional = movimientoService.update(id, movimiento);
        if (movimientoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(movimientoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Movimiento> movimientoOptional = movimientoService.deleteById(id);
        if (movimientoOptional.isPresent()) {
            return ResponseEntity.ok(movimientoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
