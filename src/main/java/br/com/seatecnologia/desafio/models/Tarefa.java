package br.com.seatecnologia.desafio.models;


public class Tarefa {

	private Long id;
	
	private String descricao;
	private Boolean estaConcluida;
	private Integer index;
	
	private Funcionario funcionario;

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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
