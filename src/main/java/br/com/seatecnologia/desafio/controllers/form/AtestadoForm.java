package br.com.seatecnologia.desafio.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.seatecnologia.desafio.controllers.repositoryes.AtestadoRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.FuncionarioRepository;
import br.com.seatecnologia.desafio.models.Atestado;
import br.com.seatecnologia.desafio.models.Funcionario;

public class AtestadoForm {
	
	@NotNull
	private String link;
	@NotNull
	private String descricao;

	private Long funcionarioId;
	
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
	public Atestado converter(FuncionarioRepository funcionarioRepository) {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(getFuncionarioId());
		Funcionario funcionario = optionalFuncionario.get();
		
		return new Atestado(link, descricao, funcionario);
	}
	
	public Atestado converter() {
		return new Atestado();
	}
	
	public Atestado atualizar(Long id, AtestadoRepository atestadoRepository) {
		
		Atestado atestado = atestadoRepository.getOne(id);
		atestado.setLink(link);
		atestado.setDescricao(descricao);
		
		return atestado;
	}
}