package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.EPI;

public interface EPIRepository extends JpaRepository<EPI, Long> {
	
	Page<EPI> findByTipo(String tipo, Pageable pagination);
	
	Optional<EPI> findById(Long id);

}
