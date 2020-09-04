package br.com.seatecnologia.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String nome;
	private String sexo;
	private String cpf;
	private String dataDeNascimento;
	private String rg;
	private String cargo;
	private Boolean estaAtivo;
	private Boolean usaEPI;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String sexo, String cpf, String dataDeNascimento, String rg, String cargo, Boolean estaAtivo, Boolean usaEPI) {
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.rg = rg;
		this.cargo = cargo;
		this.estaAtivo = estaAtivo;
		this.usaEPI = usaEPI;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Boolean getEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(Boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}

	public Boolean getUsaEPI() {
		return usaEPI;
	}

	public void setUsaEPI(Boolean usaEPI) {
		this.usaEPI = usaEPI;
	}
	
	@Override
	public String toString() {

		return this.getNome() + " id:" + this.getId();
	}
	
}
