package com.neo.demoapp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;


import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.models.entity.Persona;

import reactor.core.publisher.Mono;

public interface IPersonaService {

    List<Persona> listarTodo();
    Optional<Persona> porId(Long id);
    void eliminar(Long id);
    Persona actualizar(Persona persona);
	Persona guardar(Persona personas);

   
}
