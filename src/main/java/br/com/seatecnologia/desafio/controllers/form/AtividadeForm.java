package br.com.seatecnologia.desafio.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import br.com.seatecnologia.desafio.controllers.repositoryes.AtividadeRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.FuncionarioRepository;
import br.com.seatecnologia.desafio.models.Atividade;
import br.com.seatecnologia.desafio.models.Funcionario;

public class AtividadeForm {
	
	@NotNull @NotEmpty
	private String nome;
	@Nullable
	private Long funcionarioId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	
	public void setFuncionarioId(Long epiId) {
		this.funcionarioId = epiId;
	}
	
	public Atividade converter(FuncionarioRepository funcionarioRepository) {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(getFuncionarioId());
		Funcionario funcionario = optionalFuncionario.get();

		return new Atividade(nome, funcionario);
	}
	
	public Atividade converter() {
		
		return new Atividade(nome);
	}
	
	public Atividade atualizar(Long id, AtividadeRepository atividadeRepository) {
		Atividade atividade = atividadeRepository.getOne(id);
		
		atividade.setNome(this.nome);
		
		return atividade;
	}
}