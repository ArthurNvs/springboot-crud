package br.com.seatecnologia.desafio.controllers.dto;

import org.springframework.data.domain.Page;

import br.com.seatecnologia.desafio.models.Tarefa;

public class TarefaDTO {

	private Long id;

	private String descricao;
	private Boolean estaConcluida;
	private Integer index;
	private ProcessoDTO processo;
	
	public TarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.descricao = tarefa.getDescricao();
		this.estaConcluida = tarefa.getEstaConcluida();
		this.index = tarefa.getIndex();
		this.processo = new ProcessoDTO(tarefa.getProcesso());
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Boolean getEstaConcluida() {
		return estaConcluida;
	}

	public Integer getIndex() {
		return index;
	}
	
	public ProcessoDTO getProcesso() {
		return processo;
	}
	
	public static Page<TarefaDTO> converterParaDTO(Page<Tarefa> tarefas) {
		return tarefas.map(TarefaDTO::new);
	}

}
