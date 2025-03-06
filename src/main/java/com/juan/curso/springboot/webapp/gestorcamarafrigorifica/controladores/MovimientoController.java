package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.MovimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Movimiento> getById(@PathVariable Integer id) { return movimientoService.findById(id); }

    @PostMapping
    public Movimiento create(@RequestBody Movimiento movimiento) { return movimientoService.save(movimiento); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { movimientoService.deleteById(id); }
}
