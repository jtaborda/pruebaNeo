package com.neo.demoapp.models.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimientos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   @Column(name = "id")
     private Long id;

  @Column(name = "fecha")
  private String fecha;

  @Column(name = "valor")
  private Integer valor;

  @Column(name = "saldoInicial")
  private Integer saldoInicial;

@Column(name = "tipoCuenta")
  private String tipoCuenta;

@Column(name = "saldoDisponible")
  private Integer saldoDisponible;

@Column(name = "estado")
  private Integer estado;

@Column(name = "cuentas_id")
private Long cuentas_id;

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

public Integer getValor() {
	return valor;
}

public void setValor(Integer valor) {
	this.valor = valor;
}

public Integer getSaldoInicial() {
	return saldoInicial;
}

public void setSaldoInicial(Integer saldoInicial) {
	this.saldoInicial = saldoInicial;
}

public Integer getSaldoDisponible() {
	return saldoDisponible;
}

public void setSaldoDisponible(Integer saldoDisponible) {
	this.saldoDisponible = saldoDisponible;
}

public Integer getEstado() {
	return estado;
}

public void setEstado(Integer estado) {
	this.estado = estado;
}



public Long getCuentas_id() {
	return cuentas_id;
}

public void setCuentas_id(Long cuentas_id) {
	this.cuentas_id = cuentas_id;
}

public String getTipoCuenta() {
	return tipoCuenta;
}

public void setTipoCuenta(String tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}

}
