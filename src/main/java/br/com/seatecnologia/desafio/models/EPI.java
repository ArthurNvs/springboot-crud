package br.com.seatecnologia.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EPI {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String tipo;
	private String numeroCA;
	
	@ManyToOne
	private Atividade atividade;
	
	public EPI() {
		
	}

	public EPI(String tipo, String numeroCA) {
		this.tipo = tipo;
		this.numeroCA = numeroCA;
	}
	
	public EPI(String tipo, String numeroCA, Atividade atividade) {
		this.tipo = tipo;
		this.numeroCA = numeroCA;
		this.atividade = atividade;
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

	public String getNumeroCA() {
		return numeroCA;
	}

	public void setNumeroCA(String numeroCA) {
		this.numeroCA = numeroCA;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
}
