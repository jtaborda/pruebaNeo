package com.neo.demoapp.models.entity;


import java.util.List;

import javax.persistence.*;

@Entity
public class Clientes {
    

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	 @Column(name = "contrasenia")
	 private String contrasenia;

      @Column(name = "estado")
	  private Integer estado;

  	@Column(name = "persona_id")
    private Long persona_id;
	
  	
  	
	public Long getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Long persona_id) {
		this.persona_id = persona_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	

}
