package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.controladores;



import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.DetalleOrden;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.DetalleOrdenServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-orden")
public class DetalleOrdenController {
    @Autowired
    private DetalleOrdenServiceImpl detalleOrdenService;

    @GetMapping
    public List<DetalleOrden> getAll() {
        return detalleOrdenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrden> getById(@PathVariable Integer id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenService.findById(id);
        if (detalleOrden.isPresent()) {
            return ResponseEntity.ok(detalleOrden.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetalleOrden> create(@RequestBody DetalleOrden detalleOrden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenService.save(detalleOrden));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrden> update(@PathVariable Integer id, @Valid @RequestBody DetalleOrden detalleOrden) {
        Optional<DetalleOrden> detalleOrdenOptional = detalleOrdenService.update(id, detalleOrden);
        if (detalleOrdenOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<DetalleOrden> detalleOrdenOptional = detalleOrdenService.deleteById(id);
        if (detalleOrdenOptional.isPresent()) {
            return ResponseEntity.ok(detalleOrdenOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
