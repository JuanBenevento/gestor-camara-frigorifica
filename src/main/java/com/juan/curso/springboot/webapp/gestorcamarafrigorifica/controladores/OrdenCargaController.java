package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.OrdenCarga;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.OrdenCargaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OrdenCarga> getById(@PathVariable Integer id) {
        Optional<OrdenCarga> ordenCarga = ordenCargaService.findById(id);
        if (ordenCarga.isPresent()) {
            return ResponseEntity.ok(ordenCarga.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrdenCarga> create(@RequestBody OrdenCarga ordenCarga) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCargaService.save(ordenCarga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCarga> update(@PathVariable Integer id, @RequestBody OrdenCarga ordenCarga) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCargaService.save(ordenCarga));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { ordenCargaService.deleteById(id); }
}
