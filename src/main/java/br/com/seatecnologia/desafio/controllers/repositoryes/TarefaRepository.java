package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	Optional<Tarefa> findById(Long id);
	
	Page<Tarefa> findById(Long id, Pageable pagination);
}