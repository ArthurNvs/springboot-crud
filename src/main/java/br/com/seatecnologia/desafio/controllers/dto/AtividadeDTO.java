package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Atividade;

public class AtividadeDTO {
	
	private Long id;
	private String nome;
	private FuncionarioDTO funcionario;
	
	public AtividadeDTO(Atividade atividade) {
		this.id = atividade.getId();
		this.nome = atividade.getNome();
		this.funcionario = new FuncionarioDTO(atividade.getFuncionario());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public FuncionarioDTO getEpi() {
		return funcionario;
	}
	
	public static Page<AtividadeDTO> converterParaDTO(Page<Atividade> atividades) {
		return atividades.map(AtividadeDTO::new);
	}
}
