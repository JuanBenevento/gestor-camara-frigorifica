package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.DetalleOrden;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;


    @Transactional(readOnly = true)
    @Override
    public List<DetalleOrden> findAll() {
        return detalleOrdenRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DetalleOrden> findById(Integer id) {
        return detalleOrdenRepository.findById(id);
    }

    @Transactional
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        detalleOrdenRepository.deleteById(id);
    }
}
