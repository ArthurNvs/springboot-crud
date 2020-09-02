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
	private Character sexo;
	private String cpf;
	private String dataDeNascimento;
	private String rg;
	private String cargo;
	private String atestadoDeSaude;
	private Boolean estaAtivo;
	private Boolean usaEPI;
	
//	private Tarefa tarefa;
//	private Atividade atividade;
	
	public Funcionario() {
		
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
	
	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
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
	
	public String getAtestadoDeSaude() {
		return atestadoDeSaude;
	}
	
	public void setAtestadoDeSaude(String atestadoDeSaude) {
		this.atestadoDeSaude = atestadoDeSaude;
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
	
//	public Tarefa getTarefa() {
//		return tarefa;
//	}
//	public void setTarefa(Tarefa tarefa) {
//		this.tarefa = tarefa;
//	}
//	public Atividade getAtividade() {
//		return atividade;
//	}
//	public void setAtividade(Atividade atividade) {
//		this.atividade = atividade;
//	}

}
