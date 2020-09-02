package br.com.seatecnologia.desafio.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.seatecnologia.desafio.controllers.repositoryes.AtividadeRepository;
import br.com.seatecnologia.desafio.models.Atividade;

public class AtividadeForm {
	
	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Atividade atualizar(Long id, AtividadeRepository atividadeRepository) {
		Atividade atividade = atividadeRepository.getOne(id);
		
		atividade.setNome(this.nome);
		
		return atividade;
	}
	
	public Atividade converter(AtividadeRepository ativdadeRepository) {
		return new Atividade(nome);
	}

}
