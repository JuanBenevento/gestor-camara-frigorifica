package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.PaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Pale> getById(@PathVariable Integer id) {
        Optional<Pale> pale = paleService.findById(id);
        if (pale.isPresent()) {
            return ResponseEntity.ok(pale.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pale> create(@RequestBody Pale pale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paleService.save(pale));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pale> update(@PathVariable Integer id, @RequestBody Pale pale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paleService.save(pale));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { paleService.deleteById(id); }

}
