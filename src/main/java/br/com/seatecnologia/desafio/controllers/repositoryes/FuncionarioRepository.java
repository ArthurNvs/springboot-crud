package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	Optional<Funcionario> findById(Long id);
	
	Page<Funcionario> findByNome(String nome, Pageable pagination);

}