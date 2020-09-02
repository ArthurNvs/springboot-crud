package br.com.seatecnologia.desafio.config.validacao;

public class FormularioDeErroDTO {
	private String field;
	private String error;

	public FormularioDeErroDTO(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return error;
	}
}
