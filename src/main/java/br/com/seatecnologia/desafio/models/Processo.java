package br.com.seatecnologia.desafio.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Processo {
	
	@Id
	private Long id;
	
	private String nome;
	
	public Processo() {}
	
	public Processo(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}