package com.neo.demoapp.service.impl;


import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.repository.ClientesRepository;
import com.neo.demoapp.service.IClientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IClientesServiceImpl implements IClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> listarTodo() {
        return clientesRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Clientes> porId(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    @Transactional
    public Clientes guardar(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
    	clientesRepository.deleteById(id);
    }
    
    
    @Override
    @Transactional
    public Clientes actualizar(Clientes clientes) {
    	return clientesRepository.save(clientes);
    }
    
   
    
 
}
