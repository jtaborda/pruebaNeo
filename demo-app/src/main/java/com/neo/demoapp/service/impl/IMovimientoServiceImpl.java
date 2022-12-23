package com.neo.demoapp.service.impl;



import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Reportes;
import com.neo.demoapp.repository.IMovimientosRepository;
import com.neo.demoapp.service.IMovimientoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IMovimientoServiceImpl implements IMovimientoServices {

    @Autowired
    private IMovimientosRepository iMovimientosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Movimientos> listarTodo() {
        return iMovimientosRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Movimientos> porId(Long id) {
        return iMovimientosRepository.findById(id);
    }

    @Override
    @Transactional
    public Movimientos guardar(Movimientos movimientos) {
        return iMovimientosRepository.save(movimientos);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
    	iMovimientosRepository.deleteById(id);
    }
    
    
    @Override
    @Transactional
    public Movimientos actualizar(Movimientos movimientos) {
    	return iMovimientosRepository.save(movimientos);
    }

	@Override
	public List<Reportes> reportesFechas(Long clientIesd, String fechaInicial, String fechaFinal) {
		return iMovimientosRepository.reportesFechas(clientIesd);
	}
    
   
    
 
}
