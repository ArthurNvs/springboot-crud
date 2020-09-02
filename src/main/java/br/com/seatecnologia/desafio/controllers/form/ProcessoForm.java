package br.com.seatecnologia.desafio.controllers.form;

import br.com.seatecnologia.desafio.controllers.repositoryes.ProcessoRepository;
import br.com.seatecnologia.desafio.models.Processo;

public class ProcessoForm {
	
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
