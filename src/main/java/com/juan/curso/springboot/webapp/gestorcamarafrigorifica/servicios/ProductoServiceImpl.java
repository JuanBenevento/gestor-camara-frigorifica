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

    @Override
    public Optional<Producto> update(Integer id, Producto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto productoDb = productoOptional.orElseThrow();
            productoDb.setNombre(producto.getNombre());
            productoDb.setTipo(producto.getTipo());
            productoDb.setPeso(producto.getPeso());
            productoDb.setFechaIngreso(producto.getFechaIngreso());
            productoDb.setLote(producto.getLote());
            productoDb.setEstado(producto.getEstado());
            return Optional.of(productoRepository.save(productoDb));
        }
        return productoOptional;
    }

    @Transactional
    @Override
    public Optional<Producto> deleteById(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        productoOptional.ifPresent(productoDb -> {
            productoRepository.delete(productoDb);
        });
        return productoOptional;
    }
}
