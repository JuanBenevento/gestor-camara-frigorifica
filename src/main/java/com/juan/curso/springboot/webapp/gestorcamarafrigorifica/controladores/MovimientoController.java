package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.MovimientoServiceImpl;
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
    public ResponseEntity<Movimiento> update(@PathVariable Integer id, @RequestBody Movimiento movimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimiento));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { movimientoService.deleteById(id); }
}
