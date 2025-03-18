package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
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

    @Override
    public Optional<DetalleOrden> update(Integer id, DetalleOrden detalleOrden) {
        Optional<DetalleOrden> detalleOrdenOptional = detalleOrdenRepository.findById(id);
        if (detalleOrdenOptional.isPresent()) {
            DetalleOrden detalleOrdenDb = detalleOrdenOptional.orElseThrow();
            detalleOrdenDb.setOrdenCarga(detalleOrden.getOrdenCarga());
            detalleOrdenDb.setProducto(detalleOrden.getProducto());
            detalleOrdenDb.setCantidad(detalleOrden.getCantidad());
            return Optional.of(detalleOrdenRepository.save(detalleOrdenDb));
        }
        return detalleOrdenOptional;
    }

    @Transactional
    @Override
    public Optional<DetalleOrden> deleteById(Integer id) {
        Optional<DetalleOrden> detalleOrdenOptional = detalleOrdenRepository.findById(id);
        detalleOrdenOptional.ifPresent(detalleOrdenDb -> {
            detalleOrdenRepository.delete(detalleOrdenDb);
        });
        return detalleOrdenOptional;
    }
}
