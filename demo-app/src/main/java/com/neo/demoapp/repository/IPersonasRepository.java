package com.neo.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Persona;



public interface  IPersonasRepository extends JpaRepository<Persona, Long>{

	
}

