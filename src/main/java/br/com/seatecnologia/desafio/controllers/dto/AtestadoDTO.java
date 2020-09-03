package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Atestado;

public class AtestadoDTO {
	
	private Long id;
	private String link;
	private String descricao;
	
	public AtestadoDTO(Atestado atestado) {
		this.id = atestado.getId();
		this.link = atestado.getLink();
		this.descricao = atestado.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Page<AtestadoDTO> converterParaDTO(Page<Atestado> atestados) {
		return atestados.map(AtestadoDTO::new);
	}

}
