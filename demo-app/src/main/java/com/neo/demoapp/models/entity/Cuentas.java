package com.neo.demoapp.models.entity;


import javax.persistence.*;


@Entity
public class Cuentas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   @Column(name = "id")
   private Long id;

  @Column
  private Integer numeroCuenta;

  public Integer getSaldoInicial() {
	return saldoInicial;
}

public void setSaldoInicial(Integer saldoInicial) {
	this.saldoInicial = saldoInicial;
}

public String getTipoCuenta() {
	return tipoCuenta;
}

public void setTipoCuenta(String tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}

@Column
  private Integer saldoInicial;
  
  @Column
  private String tipoCuenta; 
  

  @Column
  private Boolean estado;

  @Column
  private Long clientes_id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getNumeroCuenta() {
	return numeroCuenta;
}

public void setNumeroCuenta(Integer numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
}

public Boolean getEstado() {
	return estado;
}

public void setEstado(Boolean estado) {
	this.estado = estado;
}

public Long getClientes_id() {
	return clientes_id;
}

public void setClientes_id(Long clientes_id) {
	this.clientes_id = clientes_id;
}

}
