package com.neoris.pruebatecnica.task;

import com.neoris.pruebatecnica.dto.MovimientoDto;
import com.neoris.pruebatecnica.dto.MovimientoPatchDto;
import org.springframework.http.ResponseEntity;

public interface MovimientoTask {

    ResponseEntity crearMovimiento(MovimientoDto movimientoDto);

    ResponseEntity obtenerMovimientoPorId(Integer idMovimiento);

    ResponseEntity editarMovimiento(MovimientoDto movimientoDto);

    ResponseEntity actualizarMovimiento(Integer idMovimiento, MovimientoPatchDto movimiento);

    ResponseEntity eliminarMovimiento(Integer idMovimiento);

    ResponseEntity obtenerReportePorFechas(String fechaInicial, String fechaFinal, Integer idCliente);

}
