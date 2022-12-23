package com.neo.demoapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Reportes;

public interface IMovimientoServices {

    List<Movimientos> listarTodo();
    Optional<Movimientos> porId(Long id);
    Movimientos guardar(Movimientos movimientos);
    void eliminar(Long id);
   Movimientos actualizar(Movimientos movimientos);
   List<Reportes> reportesFechas(Long clienteid, String fechaInicial, String fechaFinal);
}