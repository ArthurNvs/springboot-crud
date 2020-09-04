package br.com.seatecnologia.desafio.controllers.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import br.com.seatecnologia.desafio.controllers.repositoryes.AtividadeRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.EPIRepository;
import br.com.seatecnologia.desafio.models.Atividade;
import br.com.seatecnologia.desafio.models.EPI;

public class EPIForm {

	@NotNull
	@NotEmpty
	private String tipo;

	@NotNull
	@NotEmpty
	private String numeroCA;

	@Nullable
	private Long atividadeId;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroCA() {
		return numeroCA;
	}

	public void setNumeroCA(String numeroCA) {
		this.numeroCA = numeroCA;
	}

	public Long getAtividadeId() {
		return atividadeId;
	}

	public void setAtividadeId(Long atividadeId) {
		this.atividadeId = atividadeId;
	}

	public EPI converter() {

		return new EPI(tipo, numeroCA);
	}

	public EPI converter(AtividadeRepository atividadeRepository) {
		Optional<Atividade> optionalAtividade = atividadeRepository.findById(getAtividadeId());
		Atividade atividade = optionalAtividade.get();
		
		return new EPI(tipo, numeroCA, atividade);
	}

	public EPI atualizar(Long id, EPIRepository epiRepository) {
		EPI epi = epiRepository.getOne(id);

		epi.setTipo(this.tipo);
		epi.setNumeroCA(numeroCA);

		return epi;
	}

}