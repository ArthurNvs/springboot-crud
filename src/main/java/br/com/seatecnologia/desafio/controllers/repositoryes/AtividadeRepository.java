package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
	
	Page<Atividade> findByNome(String nome, Pageable pagination);

	Optional<Atividade> findById(Long id);

}