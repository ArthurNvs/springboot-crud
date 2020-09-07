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

import br.com.seatecnologia.desafio.controllers.dto.EpiDTO;
import br.com.seatecnologia.desafio.controllers.form.EPIForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.AtividadeRepository;
import br.com.seatecnologia.desafio.controllers.repositoryes.EPIRepository;
import br.com.seatecnologia.desafio.models.EPI;

@RestController
@RequestMapping("/epi")
public class EPIController {
	
	@Autowired
	EPIRepository epiRepository;
	
	@Autowired
	AtividadeRepository atividadeRepository;
	
	//Métodos de Leitura
		@GetMapping
		public Page<EpiDTO> listarEpis(@RequestParam(required = false) String param, 
				@PageableDefault(sort = "tipo", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
			
			if (param == null) {
				Page<EPI> epis = epiRepository.findAll(pagination);
				return EpiDTO.converterParaDTO(epis);
			} else {
				Page<EPI> epis = epiRepository.findByTipo(param, pagination);
				return EpiDTO.converterParaDTO(epis);
			}
		}

		@GetMapping("/{id}")
		public ResponseEntity<EpiDTO> detalharEpis(@PathVariable Long id) {

			Optional<EPI> epi = epiRepository.findById(id);
			if (epi.isPresent()) {
				return ResponseEntity.ok(new EpiDTO(epi.get()));
			}

			return ResponseEntity.notFound().build();

		}

		// Métodos de Escrita
		@PostMapping
		@Transactional
		public ResponseEntity<EpiDTO> cadastrarEpi(@RequestBody @Valid EPIForm form,
				UriComponentsBuilder uriBuilder) {

			EPI epi = form.converter(atividadeRepository);
			epiRepository.save(epi);

			URI uri = uriBuilder.path("/epi/{id}").buildAndExpand(epi.getId()).toUri();
			return ResponseEntity.created(uri).body(new EpiDTO(epi));
		}

		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<EpiDTO> atualizarEpi(@PathVariable Long id, @RequestBody @Valid EPIForm form) {

			Optional<EPI> optionalEPI = epiRepository.findById(id);
			if (optionalEPI.isPresent()) {
				EPI epi = form.atualizar(id, epiRepository);
				return ResponseEntity.ok(new EpiDTO(epi));
			}

			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> excluirEpi(@PathVariable Long id) {
			
			Optional<EPI> optionalEPI = epiRepository.findById(id);
			if (optionalEPI.isPresent()) {
				epiRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			
			return ResponseEntity.notFound().build();
		}
}
