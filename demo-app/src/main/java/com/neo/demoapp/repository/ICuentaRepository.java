package com.neo.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demoapp.models.entity.Cuentas;



public interface  ICuentaRepository extends JpaRepository<Cuentas, Long>{

}

