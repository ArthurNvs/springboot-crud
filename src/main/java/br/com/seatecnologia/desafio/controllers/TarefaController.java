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

import br.com.seatecnologia.desafio.controllers.dto.TarefaDTO;
import br.com.seatecnologia.desafio.controllers.form.TarefaForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.ProcessoRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.TarefaRepository;
import br.com.seatecnologia.desafio.models.Tarefa;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

		@Autowired
		TarefaRepository tarefaRepository;
		
		@Autowired
		ProcessoRepository processoRepository;

		// Métodos de Leitura
		@GetMapping
		public Page<TarefaDTO> listarTarefas(@RequestParam(required = false) Long param,
				@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

			if (param == null) {
				Page<Tarefa> tarefas = tarefaRepository.findAll(pagination);
				return TarefaDTO.converterParaDTO(tarefas);
			} else {
				Page<Tarefa> tarefas = tarefaRepository.findById(param, pagination);
				return TarefaDTO.converterParaDTO(tarefas);
			}
		}

		@GetMapping("/{id}")
		public ResponseEntity<TarefaDTO> detalharTarefas(@PathVariable Long id) {

			Optional<Tarefa> tarefa = tarefaRepository.findById(id);
			if (tarefa.isPresent()) {
				return ResponseEntity.ok(new TarefaDTO(tarefa.get()));
			}

			return ResponseEntity.notFound().build();

		}

		// Métodos de Escrita
		@PostMapping
		@Transactional
		public ResponseEntity<TarefaDTO> cadastrarTarefa(@RequestBody @Valid TarefaForm form,
				UriComponentsBuilder uriBuilder) {

			Tarefa tarefa = form.converter(processoRepository);
			tarefaRepository.save(tarefa);

			URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
			return ResponseEntity.created(uri).body(new TarefaDTO(tarefa));
		}

		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id,
				@RequestBody @Valid TarefaForm form) {

			Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
			if (optionalTarefa.isPresent()) {
				Tarefa tarefa = form.atualizar(id, tarefaRepository);
				return ResponseEntity.ok(new TarefaDTO(tarefa));
			}

			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> excluirTarefa(@PathVariable Long id) {

			Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
			if (optionalTarefa.isPresent()) {
				tarefaRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();
		}
}
