package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;


import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Producto;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Transactional
    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}
