package br.com.seatecnologia.desafio.controllers.form;

import br.com.seatecnologia.desafio.controllers.repositoryes.FuncionarioRepository;
import br.com.seatecnologia.desafio.models.Funcionario;

public class FuncionarioForm {
	
	private String nome;
	private Character sexo;
	private String cpf;
	private String dataDeNascimento;
	private String rg;
	private String cargo;
	private String atestadoDeSaude;
	private Boolean estaAtivo;
	private Boolean usaEPI;
	
	
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
	
	public Funcionario converterParaFuncionario() {
		return new Funcionario();
	}
	
	public Funcionario atualizar(Long id, FuncionarioRepository funcionarioRepository) {
		
		Funcionario funcionario = funcionarioRepository.getOne(id);
		
		funcionario.setNome(this.nome);
		funcionario.setSexo(this.sexo);
		funcionario.setCpf(this.cpf);
		funcionario.setDataDeNascimento(this.dataDeNascimento);
		funcionario.setRg(this.rg);
		funcionario.setCargo(this.cargo);
		funcionario.setEstaAtivo(this.estaAtivo);
		funcionario.setUsaEPI(this.usaEPI);
		
		return funcionario;
	}
}
