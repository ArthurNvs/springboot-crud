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

import br.com.seatecnologia.desafio.controllers.dto.ProcessoDTO;
import br.com.seatecnologia.desafio.controllers.form.ProcessoForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.ProcessoRepository;
import br.com.seatecnologia.desafio.models.Processo;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

	@Autowired
	ProcessoRepository processoRepository;

	// Métodos de Leitura
	@GetMapping
	public Page<ProcessoDTO> listarProcessos(@RequestParam(required = false) String param,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		if (param == null) {
			Page<Processo> processos = processoRepository.findAll(pagination);
			return ProcessoDTO.converterParaDTO(processos);
		} else {
			Page<Processo> processos = processoRepository.findByNome(param, pagination);
			return ProcessoDTO.converterParaDTO(processos);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProcessoDTO> detalharProcessos(@PathVariable Long id) {

		Optional<Processo> processo = processoRepository.findById(id);
		if (processo.isPresent()) {
			return ResponseEntity.ok(new ProcessoDTO(processo.get()));
		}

		return ResponseEntity.notFound().build();

	}

	// Métodos de Escrita
	@PostMapping
	@Transactional
	public ResponseEntity<ProcessoDTO> cadastrarProcesso(@RequestBody @Valid ProcessoForm form,
			UriComponentsBuilder uriBuilder) {

		Processo processo = form.converter(processoRepository);
		processoRepository.save(processo);

		URI uri = uriBuilder.path("/processo/{id}").buildAndExpand(processo.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProcessoDTO(processo));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProcessoDTO> atualizarProcesso(@PathVariable Long id, @RequestBody @Valid ProcessoForm form) {

		Optional<Processo> optionalProcesso = processoRepository.findById(id);
		if (optionalProcesso.isPresent()) {
			Processo processo = form.atualizar(id, processoRepository);
			return ResponseEntity.ok(new ProcessoDTO(processo));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirProcesso(@PathVariable Long id) {

		Optional<Processo> optionalProcesso = processoRepository.findById(id);
		if (optionalProcesso.isPresent()) {
			processoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
