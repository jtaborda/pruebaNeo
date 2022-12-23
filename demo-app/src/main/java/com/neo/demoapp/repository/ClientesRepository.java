package com.neo.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.demoapp.models.entity.Clientes;


public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}