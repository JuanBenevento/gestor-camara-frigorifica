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

    @Override
    public Optional<Pale> update(Integer id, Pale pale) {
        Optional<Pale> paleOptional = paleRepository.findById(id);
        if (paleOptional.isPresent()) {
            Pale paleDb = paleOptional.orElseThrow();
            paleDb.setCamara(pale.getCamara());
            paleDb.setCodigo(pale.getCodigo());
            paleDb.setCapacidad(pale.getCapacidad());
            return Optional.of(paleRepository.save(paleDb));
        }
        return paleOptional;
    }

    @Transactional
    @Override
    public Optional<Pale> deleteById(Integer id) {
        Optional<Pale> paleOptional = paleRepository.findById(id);
        paleOptional.ifPresent(paleDb -> {
            paleRepository.delete(paleDb);
        });
        return paleOptional;
    }
}
