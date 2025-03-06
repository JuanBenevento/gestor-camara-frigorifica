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

    @Transactional
    @Override
    public void deleteById(Integer id) {
        movimientoRepository.deleteById(id);
    }
}
