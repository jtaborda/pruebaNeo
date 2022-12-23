package com.neo.demoapp.service;

import java.util.List;
import java.util.Optional;

import com.neo.demoapp.models.entity.Clientes;

public interface IClientesService {

    List<Clientes> listarTodo();
    Optional<Clientes> porId(Long id);
    Clientes guardar(Clientes clientes);
   void eliminar(Long id);
   Clientes actualizar(Clientes clientes);
   
}
