package br.com.seatecnologia.desafio.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.seatecnologia.desafio.controllers.repositoryes.ProcessoRepository;
import br.com.seatecnologia.desafio.models.Processo;

public class ProcessoForm {
	
	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Processo atualizar(Long id, ProcessoRepository processoRepository) {
		Processo processo = processoRepository.getOne(id);

		processo.setNome(this.nome);

		return processo;
	}

	public Processo converter(ProcessoRepository processoRepository) {

		return new Processo(nome);
	}

}
