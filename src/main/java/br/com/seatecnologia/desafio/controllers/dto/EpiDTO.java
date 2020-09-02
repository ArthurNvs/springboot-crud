package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.EPI;

public class EpiDTO {
	
	private Long id;
	private String tipo;
	
	public EpiDTO(EPI epi) {
		this.id = epi.getId();
		this.tipo = epi.getTipo();
	}	
	
	
	public Long getId() {
		return id;
	}


	public String getTipo() {
		return tipo;
	}


	public static Page<EpiDTO> converterParaDTO(Page<EPI> epis) {
		return epis.map(EpiDTO::new);
	}

}