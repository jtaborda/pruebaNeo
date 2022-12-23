package com.neo.demoapp.service.impl;



import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Persona;
import com.neo.demoapp.models.entity.Reportes;
import com.neo.demoapp.repository.IMovimientosRepository;
import com.neo.demoapp.repository.IPersonasRepository;
import com.neo.demoapp.service.IMovimientoServices;
import com.neo.demoapp.service.IPersonaService;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IPersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonasRepository iPersonasRepository;

    @Transactional(readOnly = true)
    public List<Persona> listarTodo() {
        return iPersonasRepository.findAll();
    }

    @Transactional
    public Optional<Persona> porId(Long id) {
        return iPersonasRepository.findById(id);
    }


    @Transactional
    public Persona guardar(Persona persona) {
        return iPersonasRepository.save(persona);
    }


    @Transactional
    public void eliminar(Long id) {
    	iPersonasRepository.deleteById(id);
    }
    
    
    @Transactional
    public Persona actualizar(Persona persona) {
    	return iPersonasRepository.save(persona);
    }


   
 
}
