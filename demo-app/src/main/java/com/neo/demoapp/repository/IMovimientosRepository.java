package com.neo.demoapp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neo.demoapp.models.entity.Movimientos;
import com.neo.demoapp.models.entity.Reportes;


@Repository
public interface IMovimientosRepository extends JpaRepository<Movimientos, Long>{	

	@Query(value ="select mvts.fecha,persona.nombres,ctas.numeroCuenta, ctas.tipoCuenta,ctas.saldoInicial,ctas.estado,mvts.saldoDisponible FROM Cuentas ctas INNER JOIN Movimientos mvts on mvts.cuentas_id = ctas.id INNER JOIN Clientes clientes on clientes.id = ctas.clientes_id INNER JOIN Persona persona on persona.id=clientes.persona_id  WHERE clientes.id = :clientIesd and 1=1 ")	
	 List<Reportes> reportesFechas( @Param("clientIesd")Long clientIesd);

}

