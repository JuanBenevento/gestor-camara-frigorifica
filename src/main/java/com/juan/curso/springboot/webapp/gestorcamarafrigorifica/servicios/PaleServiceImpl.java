package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Pale;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.PaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaleServiceImpl implements PaleService {
    @Autowired
    private PaleRepository paleRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Pale> findAll() {
        return paleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pale> findById(Integer id) {
        return paleRepository.findById(id);
    }

    @Transactional
    @Override
    public Pale save(Pale pale) {
        return paleRepository.save(pale);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        paleRepository.deleteById(id);
    }
}
