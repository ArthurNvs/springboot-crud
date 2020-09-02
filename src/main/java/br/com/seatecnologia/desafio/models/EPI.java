package br.com.seatecnologia.desafio.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EPI {

	@Id
	private Long id;

	private String tipo;
	
	public EPI(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
