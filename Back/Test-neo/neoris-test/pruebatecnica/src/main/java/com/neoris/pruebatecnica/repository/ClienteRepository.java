package com.neoris.pruebatecnica.repository;

import com.neoris.pruebatecnica.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query("SELECT C FROM ClienteEntity C WHERE C.persona.identificacion = :identificacion")
    Optional<ClienteEntity> findByIdentificacion(String identificacion);


}
