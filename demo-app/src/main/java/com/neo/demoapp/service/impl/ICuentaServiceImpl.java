package com.neo.demoapp.service.impl;



import com.neo.demoapp.models.entity.Cuentas;
import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.repository.ICuentaRepository;
import com.neo.demoapp.repository.IMovimientosRepository;
import com.neo.demoapp.service.ICuentaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ICuentaServiceImpl implements ICuentaServices {

    @Autowired
    private ICuentaRepository iCuentaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cuentas> listarTodo() {
        return iCuentaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Cuentas> porId(Long id) {
        return iCuentaRepository.findById(id);
    }

    @Override
    @Transactional
    public Cuentas guardar(Cuentas cuentas) {
        return iCuentaRepository.save(cuentas);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
    	iCuentaRepository.deleteById(id);
    }
    
    
    @Override
    @Transactional
    public Cuentas actualizar(Cuentas cuentas) {
    	return iCuentaRepository.save(cuentas);
    }
    
   
    
 
}
