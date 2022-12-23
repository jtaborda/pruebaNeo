package com.neo.demoapp.models.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
public class Reportes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   @Column(name = "id")
	  private Long id;	
	  private String fecha;

	public String getTipo_Cuenta() {
		return tipo_Cuenta;
	}
	public void setTipo_Cuenta(String tipo_Cuenta) {
		this.tipo_Cuenta = tipo_Cuenta;
	}
	public Integer getSaldo_Disponible() {
		return saldo_Disponible;
	}
	public void setSaldo_Disponible(Integer saldo_Disponible) {
		this.saldo_Disponible = saldo_Disponible;
	}
	public Integer getSaldo_Inicial() {
		return saldo_Inicial;
	}
	public void setSaldo_Inicial(Integer saldo_Inicial) {
		this.saldo_Inicial = saldo_Inicial;
	}
	private Integer numero_Cuenta;
	  private String tipo_Cuenta;
	  private Long movimiento_id;
	  private Long cuentas_id;
	  private Long clientes_id;
	  public Long getMovimiento_id() {
		return movimiento_id;
	}
	public void setMovimiento_id(Long movimiento_id) {
		this.movimiento_id = movimiento_id;
	}
	public Long getCuentas_id() {
		return cuentas_id;
	}
	public void setCuentas_id(Long cuentas_id) {
		this.cuentas_id = cuentas_id;
	}
	public Long getClientes_id() {
		return clientes_id;
	}
	public void setClientes_id(Long clientes_id) {
		this.clientes_id = clientes_id;
	}
	public Integer getNumero_Cuenta() {
		return numero_Cuenta;
	}
	public void setNumero_Cuenta(Integer numero_Cuenta) {
		this.numero_Cuenta = numero_Cuenta;
	}

	private Integer saldo_Disponible;
	  private Integer saldo_Inicial;
	  private Boolean estado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Integer getNumeroCuenta() {
		return numero_Cuenta;
	}
	public void setNumeroCuenta(Integer numero_Cuenta) {
		this.numero_Cuenta = numero_Cuenta;
	}
	
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
