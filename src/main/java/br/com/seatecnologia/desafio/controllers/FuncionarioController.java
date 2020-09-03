package br.com.seatecnologia.desafio.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

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

import br.com.seatecnologia.desafio.controllers.dto.FuncionarioDTO;
import br.com.seatecnologia.desafio.controllers.form.FuncionarioForm;
import br.com.seatecnologia.desafio.controllers.repositoryes.FuncionarioRepository;
import br.com.seatecnologia.desafio.models.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public Page<FuncionarioDTO> listarFuncionarios(@RequestParam(required=false) String param,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		
		if (param == null) {
			Page<Funcionario> funcionarios = funcionarioRepository.findAll(pagination);
			return FuncionarioDTO.converterParaDTO(funcionarios);
		} else {
			Page<Funcionario> funcionarios = funcionarioRepository.findByNome(param, pagination);
			return FuncionarioDTO.converterParaDTO(funcionarios);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> detailCustomer(@PathVariable Long id) {

		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(new FuncionarioDTO(funcionario.get()));
		}

		return ResponseEntity.notFound().build();

	}

	//WRITE
		@PostMapping
		@Transactional
		public ResponseEntity<FuncionarioDTO> registrarFuncionario(@RequestBody FuncionarioForm form,
				UriComponentsBuilder uriBuilder) {

			Funcionario funcionario = form.converterParaFuncionario();
			funcionarioRepository.save(funcionario);

			URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
			return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
		}

		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<FuncionarioDTO> editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioForm form) {

			Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
			if (optionalFuncionario.isPresent()) {
				Funcionario	funcionario = form.atualizar(id, funcionarioRepository);
				return ResponseEntity.ok(new FuncionarioDTO(funcionario));
			}

			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> excluirFuncionario(@PathVariable Long id) {
			
			Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
			if (optionalFuncionario.isPresent()) {
				funcionarioRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			
			return ResponseEntity.notFound().build();
		}
	
}
