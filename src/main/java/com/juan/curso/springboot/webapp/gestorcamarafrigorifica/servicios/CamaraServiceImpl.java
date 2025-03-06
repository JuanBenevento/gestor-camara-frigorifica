package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Camara;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CamaraServiceImpl implements CamaraService{
    @Autowired
    private CamaraRepository camaraRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Camara> findAll() {
        return camaraRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Camara> findById(Integer id) {
        return camaraRepository.findById(id);
    }

    @Transactional
    @Override
    public Camara save(Camara camara) {
        return camaraRepository.save(camara);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        camaraRepository.deleteById(id);
    }
}
