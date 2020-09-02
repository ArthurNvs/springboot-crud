package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Atividade;

public class AtividadeDTO {
	
	private Long id;
	private String nome;
	
	public AtividadeDTO(Atividade atividade) {
		this.id = atividade.getId();
		this.nome = atividade.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static Page<AtividadeDTO> converterParaDTO(Page<Atividade> processos) {
		return processos.map(AtividadeDTO::new);
	}
}
