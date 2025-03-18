package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.OrdenCarga;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.OrdenCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCargaServiceImpl implements OrdenCargaService {
    @Autowired
    private OrdenCargaRepository ordenCargaRepository;


    @Transactional(readOnly = true)
    @Override
    public List<OrdenCarga> findAll() {
        return ordenCargaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrdenCarga> findById(Integer id) {
        return ordenCargaRepository.findById(id);
    }

    @Transactional
    @Override
    public OrdenCarga save(OrdenCarga ordenCarga) {
        return ordenCargaRepository.save(ordenCarga);
    }

    @Override
    public Optional<OrdenCarga> update(Integer id, OrdenCarga ordenCarga) {
        Optional<OrdenCarga> ordenCargaOptional = ordenCargaRepository.findById(id);
        if (ordenCargaOptional.isPresent()) {
            OrdenCarga ordenCargaDb = ordenCargaOptional.orElseThrow();
            ordenCargaDb.setFecha(ordenCarga.getFecha());
            ordenCargaDb.setEstado(ordenCarga.getEstado());
            return Optional.of(ordenCargaRepository.save(ordenCargaDb));
        }
        return ordenCargaOptional;
    }

    @Transactional
    @Override
    public Optional<OrdenCarga> deleteById(Integer id) {
        Optional<OrdenCarga> ordenCargaOptional = ordenCargaRepository.findById(id);
        ordenCargaOptional.ifPresent(facturaDb -> {
            ordenCargaRepository.delete(facturaDb);
        });
        return ordenCargaOptional;
    }
}
