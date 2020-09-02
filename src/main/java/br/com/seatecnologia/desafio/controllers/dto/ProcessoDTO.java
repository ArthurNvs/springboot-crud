package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Processo;

public class ProcessoDTO {
	
	private Long id;
	private String nome;
	
	public ProcessoDTO(Processo processo) {
		this.id = processo.getId();
		this.nome = processo.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static Page<ProcessoDTO> converterParaDTO(Page<Processo> processos) {
		return processos.map(ProcessoDTO::new);
	}

}
