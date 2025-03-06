package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Factura;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Transactional
    @Override
    public Optional<Factura> findById(Integer id) {
        return facturaRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);
    }
}
