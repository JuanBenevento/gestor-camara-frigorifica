package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.modelos.Cliente;
import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> update(Integer id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteDb = clienteOptional.orElseThrow();
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setContacto(cliente.getContacto());
            clienteDb.setCondicionesFacturacion(cliente.getCondicionesFacturacion());
            return Optional.of(clienteRepository.save(clienteDb));
        }
        return clienteOptional;
    }

    @Transactional
    @Override
    public Optional<Cliente> deleteById(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        clienteOptional.ifPresent(clienteDb -> {
            clienteRepository.delete(clienteDb);
        });
        return clienteOptional;
    }
}
