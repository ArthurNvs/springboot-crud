package br.com.seatecnologia.desafio.controllers.form;

import br.com.seatecnologia.desafio.controllers.repositoryes.EPIRepository;
import br.com.seatecnologia.desafio.models.EPI;

public class EPIForm {

	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EPI atualizar(Long id, EPIRepository epiRepository) {
		EPI epi = epiRepository.getOne(id);

		epi.setTipo(this.tipo);

		return epi;
	}

	public EPI converter(EPIRepository epiRepository) {

		return new EPI(tipo);
	}
}