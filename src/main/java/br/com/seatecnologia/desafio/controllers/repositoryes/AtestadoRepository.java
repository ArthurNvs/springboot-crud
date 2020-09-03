package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.Atestado;

public interface AtestadoRepository extends JpaRepository<Atestado, Long> {
	
	Optional<Atestado> findById(Long id);

	Page<Atestado> findById(Long id, Pageable pagination);
}