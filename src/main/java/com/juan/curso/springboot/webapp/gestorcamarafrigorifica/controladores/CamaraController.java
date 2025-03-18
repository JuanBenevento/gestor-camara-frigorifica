package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.CamaraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camaras")
public class CamaraController {
    @Autowired
    private CamaraService camaraService;

    @GetMapping
    public List<Camara> getAll() {
        return camaraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camara> getById(@PathVariable Integer id) {
        Optional<Camara> camara = camaraService.findById(id);
        if (camara.isPresent()) {
            return ResponseEntity.ok(camara.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Camara> create(@Valid @RequestBody Camara camara) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camaraService.save(camara));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camara> update(@PathVariable Integer id,@Valid @RequestBody Camara camara) {
        Optional<Camara> camaraOptional = camaraService.update(id, camara);
        if (camaraOptional.isPresent()) {
           return ResponseEntity.status(HttpStatus.OK).body(camaraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Camara> camaraOptional = camaraService.deleteById(id);
        if (camaraOptional.isPresent()) {
            return ResponseEntity.ok(camaraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
