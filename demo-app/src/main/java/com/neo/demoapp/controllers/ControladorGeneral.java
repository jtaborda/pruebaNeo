package com.neo.demoapp.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neo.demoapp.models.entity.Clientes;
import com.neo.demoapp.models.entity.Cuentas;
import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Persona;
import com.neo.demoapp.models.entity.Reportes;
import com.neo.demoapp.repository.IMovimientosRepository;
import com.neo.demoapp.service.IClientesService;
import com.neo.demoapp.service.ICuentaServices;
import com.neo.demoapp.service.IMovimientoServices;
import com.neo.demoapp.service.IPersonaService;

import reactor.core.publisher.Mono;

import java.awt.PageAttributes.MediaType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class ControladorGeneral {
//poltaborda

    @Autowired
    private IClientesService iClientesService;
    @Autowired
    private ICuentaServices iCuentaServices;
    @Autowired
    private IMovimientosRepository iMovimientosRepository;
    @Autowired
    private IMovimientoServices iMovimientoServices;    
    @Autowired
    private IPersonaService iPersonaService;
    
    
    @PostMapping("/Personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona crearPersonas(@RequestBody Persona personas) {
        return iPersonaService.guardar(personas);
    }

   	 
    @PostMapping("/cuentas")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuentas crearCuentas(@RequestBody Cuentas cuentas) {
        return iCuentaServices.guardar(cuentas);
    }
    
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes crearClientes(@RequestBody Clientes clientes) {
        return iClientesService.guardar(clientes);
    }
    
    
    @PostMapping("/movimientos")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimientos crearMovimientos(@RequestBody Movimientos movimientos) {
        return iMovimientoServices.guardar(movimientos);
    }
    
  
    
    @GetMapping("/reportes")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<List<Reportes>> getReportes( @RequestParam  Long clienteId,
                                                          @RequestParam  String fechaInicio,
                                                          @RequestParam  String fechaFin) throws Exception {

    	List<Reportes> reportesList=iMovimientoServices.reportesFechas(clienteId, fechaInicio, fechaFin);

	return new ResponseEntity<>(reportesList, HttpStatus.OK);
    }
    
    
}
