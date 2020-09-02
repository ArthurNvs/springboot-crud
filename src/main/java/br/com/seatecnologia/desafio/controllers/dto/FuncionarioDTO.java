package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Funcionario;

public class FuncionarioDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String cargo;
	private Boolean estaAtivo;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.cargo = funcionario.getCargo();
		this.estaAtivo = funcionario.getEstaAtivo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public Boolean getEstaAtivo() {
		return estaAtivo;
	}
	
	public static Page<FuncionarioDTO> converterParaDTO(Page<Funcionario> funcionarios) {
		return funcionarios.map(FuncionarioDTO::new);
	}
}