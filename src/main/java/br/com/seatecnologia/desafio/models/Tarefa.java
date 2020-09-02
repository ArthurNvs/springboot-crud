package br.com.seatecnologia.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String descricao;
	private Boolean estaConcluida;
	private Integer index;
	
	@ManyToOne
	private Processo processo;
	
	public Tarefa() {
		
	}

	public Tarefa(String descricao, Boolean estaConcluida, Integer index, Processo processo) {
		this.descricao = descricao;
		this.estaConcluida = estaConcluida;
		this.index = index;
		this.processo = processo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEstaConcluida() {
		return estaConcluida;
	}

	public void setEstaConcluida(Boolean estaConcluida) {
		this.estaConcluida = estaConcluida;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
}
