package com.neo.demoapp.models.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Persona {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   @Column(name = "id")
	    private Long id;
	
	@Column(name = "nombres")
  private String nombres;


	@Column(name = "genero")
  private String genero;

	@Column(name = "identificacion")
  private String identificacion;

	@Column(name = "edad")
  private Integer edad;

	@Column(name = "direccion")
  private String direccion;

	@Column(name = "telefono")
  private Integer telefono;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Persona(Long id, String nombres, String genero, String identificacion, Integer edad, String direccion,
			Integer telefono) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.genero = genero;
		this.identificacion = identificacion;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
	}


}

