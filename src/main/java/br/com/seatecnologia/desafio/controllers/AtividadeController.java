package br.com.seatecnologia.desafio.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.seatecnologia.desafio.controllers.dto.AtividadeDTO;
import br.com.seatecnologia.desafio.controllers.form.AtividadeForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.AtividadeRepository;
import br.com.seatecnologia.desafio.models.Atividade;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	AtividadeRepository atividadeRepository;

	// Métodos de Leitura
	@GetMapping
	public Page<AtividadeDTO> listarAtividades(@RequestParam(required = false) String param,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		if (param == null) {
			Page<Atividade> atividades = atividadeRepository.findAll(pagination);
			return AtividadeDTO.converterParaDTO(atividades);
		} else {
			Page<Atividade> atividades = atividadeRepository.findByNome(param, pagination);
			return AtividadeDTO.converterParaDTO(atividades);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtividadeDTO> detalharAtividades(@PathVariable Long id) {

		Optional<Atividade> atividade = atividadeRepository.findById(id);
		if (atividade.isPresent()) {
			return ResponseEntity.ok(new AtividadeDTO(atividade.get()));
		}

		return ResponseEntity.notFound().build();

	}

	// Métodos de Escrita
	@PostMapping
	@Transactional
	public ResponseEntity<AtividadeDTO> cadastrarAtividade(@RequestBody @Valid AtividadeForm form,
			UriComponentsBuilder uriBuilder) {

		Atividade atividade = form.converter(atividadeRepository);
		atividadeRepository.save(atividade);

		URI uri = uriBuilder.path("/atividades/{id}").buildAndExpand(atividade.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtividadeDTO(atividade));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AtividadeDTO> atualizarAtividade(@PathVariable Long id,
			@RequestBody @Valid AtividadeForm form) {

		Optional<Atividade> optionalAtividade = atividadeRepository.findById(id);
		if (optionalAtividade.isPresent()) {
			Atividade atividade = form.atualizar(id, atividadeRepository);
			return ResponseEntity.ok(new AtividadeDTO(atividade));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirAtividade(@PathVariable Long id) {

		Optional<Atividade> optionalAtividade = atividadeRepository.findById(id);
		if (optionalAtividade.isPresent()) {
			atividadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
