package br.com.seatecnologia.desafio.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import br.com.seatecnologia.desafio.controllers.repositoryes.ProcessoRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.TarefaRepository;
import br.com.seatecnologia.desafio.models.Processo;
import br.com.seatecnologia.desafio.models.Tarefa;

public class TarefaForm {
	
	@NotNull @NotEmpty
	private String descricao;
	@NotNull
	private Boolean estaConcluida;
	@NotNull
	private Integer index;
	@Nullable
	private Long processoId;
	
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
		
	public Long getProcessoId() {
		return processoId;
	}

	public void setProcessoId(Long processoId) {
		this.processoId = processoId;
	}

	public Tarefa converter(ProcessoRepository processoRepository) {
		Optional<Processo> optionalProcesso = processoRepository.findById(getProcessoId());
		Processo processo = optionalProcesso.get();
		
		return new Tarefa(descricao, estaConcluida, index, processo);
	}
	
	public Tarefa converter() {
		return new Tarefa();
	}
	
	public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
		
		Tarefa tarefa = tarefaRepository.getOne(id);
		tarefa.setDescricao(descricao);
		tarefa.setEstaConcluida(estaConcluida);
		tarefa.setIndex(index);
		
		return tarefa;
	}
	
}