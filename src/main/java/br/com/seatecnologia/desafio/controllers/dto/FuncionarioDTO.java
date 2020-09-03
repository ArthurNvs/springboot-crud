package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Funcionario;

public class FuncionarioDTO {
	
	private Long id;
	private String nome;
	private String sexo;
	private String cpf;
	private String dataDeNascimento;
	private String rg;
	private String cargo;
	private Boolean estaAtivo;
	private Boolean usaEPI;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.sexo = funcionario.getSexo();
		this.cpf = funcionario.getCpf();
		this.dataDeNascimento = funcionario.getDataDeNascimento();
		this.rg = funcionario.getRg();
		this.cargo = funcionario.getCargo();
		this.estaAtivo = funcionario.getEstaAtivo();
		this.usaEPI = funcionario.getUsaEPI();
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
	
	public String getSexo() {
		return sexo;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getRg() {
		return rg;
	}

	public Boolean getUsaEPI() {
		return usaEPI;
	}

	public static Page<FuncionarioDTO> converterParaDTO(Page<Funcionario> funcionarios) {
		return funcionarios.map(FuncionarioDTO::new);
	}
}