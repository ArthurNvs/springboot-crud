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

import br.com.seatecnologia.desafio.controllers.dto.AtestadoDTO;
import br.com.seatecnologia.desafio.controllers.form.AtestadoForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.AtestadoRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.FuncionarioRepository;
import br.com.seatecnologia.desafio.models.Atestado;

@RestController
@RequestMapping("/atestado")
public class AtestadoController {
	
	@Autowired
	AtestadoRepository atestadoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	//Métodos de Leitura
			@GetMapping
			public Page<AtestadoDTO> listarAtestados(@RequestParam(required = false) Long param,
					@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

				if (param == null) {
					Page<Atestado> atestado = atestadoRepository.findAll(pagination);
					return AtestadoDTO.converterParaDTO(atestado);
				} else {
					Page<Atestado> atestado = atestadoRepository.findById(param, pagination);
					return AtestadoDTO.converterParaDTO(atestado);
				}
			}

			@GetMapping("/{id}")
			public ResponseEntity<AtestadoDTO> detalharAtestados(@PathVariable Long id) {

				Optional<Atestado> atestado = atestadoRepository.findById(id);
				if (atestado.isPresent()) {
					return ResponseEntity.ok(new AtestadoDTO(atestado.get()));
				}

				return ResponseEntity.notFound().build();

			}

			//Métodos de Escrita
			@PostMapping

			public ResponseEntity<AtestadoDTO> cadastrarAtestado(@RequestBody @Valid AtestadoForm form,
					UriComponentsBuilder uriBuilder) {

				Atestado atestado = form.converter(funcionarioRepository);
				atestadoRepository.save(atestado);

				URI uri = uriBuilder.path("/atestado/{id}").buildAndExpand(atestado.getId()).toUri();
				return ResponseEntity.created(uri).body(new AtestadoDTO(atestado));
			}

			@PutMapping("/{id}")
			@Transactional
			public ResponseEntity<AtestadoDTO> atualizarAtestado(@PathVariable Long id,
					@RequestBody @Valid AtestadoForm form) {

				Optional<Atestado> optionalAtestado = atestadoRepository.findById(id);
				if (optionalAtestado.isPresent()) {
					Atestado atestado = form.atualizar(id, atestadoRepository);
					return ResponseEntity.ok(new AtestadoDTO(atestado));
				}

				return ResponseEntity.notFound().build();
			}

			@DeleteMapping("/{id}")
			@Transactional
			public ResponseEntity<?> excluirAtestado(@PathVariable Long id) {

				Optional<Atestado> optionalAtestado = atestadoRepository.findById(id);
				if (optionalAtestado.isPresent()) {
					atestadoRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}

				return ResponseEntity.notFound().build();
			}

}
