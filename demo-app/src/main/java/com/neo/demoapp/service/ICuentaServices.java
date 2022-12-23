package com.neo.demoapp.service;

import java.util.List;
import java.util.Optional;

import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.models.entity.Cuentas;
import com.neo.demoapp.models.entity.Movimientos;

public interface ICuentaServices {

    List<Cuentas> listarTodo();
    Optional<Cuentas> porId(Long id);
    Cuentas guardar(Cuentas cuentas);
    void eliminar(Long id);
    Cuentas actualizar(Cuentas cuentas);
   
}