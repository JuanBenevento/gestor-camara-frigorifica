package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Movimiento;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Movimiento> findById(Integer id) {
        return movimientoRepository.findById(id);
    }

    @Transactional
    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Optional<Movimiento> update(Integer id, Movimiento movimiento) {
        Optional<Movimiento> movimientoOptional = movimientoRepository.findById(id);
        if (movimientoOptional.isPresent()) {
            Movimiento movimientoDb = movimientoOptional.orElseThrow();
            movimientoDb.setTipo(movimiento.getTipo());
            movimientoDb.setFecha(movimiento.getFecha());
            movimientoDb.setDestino(movimiento.getDestino());
            movimientoDb.setPale(movimiento.getPale());
            return Optional.of(movimientoRepository.save(movimientoDb));
        }
        return movimientoOptional;
    }

    @Transactional
    @Override
    public Optional<Movimiento> deleteById(Integer id) {
        Optional<Movimiento> movimientoOptional = movimientoRepository.findById(id);
        movimientoOptional.ifPresent(movimientoDb -> {
            movimientoRepository.delete(movimientoDb);
        });
        return movimientoOptional;
    }
}
