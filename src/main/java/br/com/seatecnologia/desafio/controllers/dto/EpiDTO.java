package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.EPI;

public class EpiDTO {
	
	private Long id;
	private String tipo;
	private String numeroCA;
	private AtividadeDTO atividade;
	
	public EpiDTO(EPI epi) {
		this.id = epi.getId();
		this.tipo = epi.getTipo();
		this.numeroCA = epi.getNumeroCA();
		this.atividade = new AtividadeDTO(epi.getAtividade());
	}	
	
	
	public Long getId() {
		return id;
	}


	public String getTipo() {
		return tipo;
	}
	
	public String getNumeroCA() {
		return numeroCA;
	}
	
	public AtividadeDTO getAtividade() {
		return atividade;
	}


	public static Page<EpiDTO> converterParaDTO(Page<EPI> epis) {
		return epis.map(EpiDTO::new);
	}
}