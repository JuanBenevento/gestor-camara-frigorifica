package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.CamaraService;
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
    public ResponseEntity<Camara> create(@RequestBody Camara camara) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camaraService.save(camara));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camara> update(@PathVariable Integer id, @RequestBody Camara camara) {
        return ResponseEntity.status(HttpStatus.CREATED).body(camaraService.save(camara));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { camaraService.deleteById(id); }
}
