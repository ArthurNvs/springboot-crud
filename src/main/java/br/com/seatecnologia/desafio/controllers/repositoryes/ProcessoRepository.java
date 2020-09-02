package br.com.seatecnologia.desafio.controllers.repositoryes;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seatecnologia.desafio.models.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

	Page<Processo> findByNome(String tipo, Pageable pagination);

	Optional<Processo> findById(Long id);

}
