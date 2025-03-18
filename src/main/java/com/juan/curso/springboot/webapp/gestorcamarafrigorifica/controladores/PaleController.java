package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.PaleService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Pale> update(@PathVariable Integer id, @Valid @RequestBody Pale pale) {
        Optional<Pale> paleOptional = paleService.update(id, pale);
        if (paleOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(paleOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Pale> paleOptional = paleService.deleteById(id);
        if (paleOptional.isPresent()) {
            return ResponseEntity.ok(paleOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
