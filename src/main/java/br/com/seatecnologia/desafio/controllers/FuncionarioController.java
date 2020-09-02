package br.com.seatecnologia.desafio.controllers;

//@RestController
//@RequestMapping("/funcionarios")
public class FuncionarioController {
//	
//	@Autowired
//	FuncionarioRepository funcionarioRepository;
//	
//	@GetMapping
//	public Page<FuncionarioDTO> listarFuncionarios(@RequestParam(required=false) String param,
//			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
//		
//		if (param == null) {
//			Page<Funcionario> funcionarios = funcionarioRepository.findAll(pagination);
//			return FuncionarioDTO.converterParaDTO(funcionarios);
//		} else {
//			Page<Funcionario> funcionarios = funcionarioRepository.findByNome(param, pagination);
//			return FuncionarioDTO.converterParaDTO(funcionarios);
//		}
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<FuncionarioDTO> detailCustomer(@PathVariable Long id) {
//
//		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
//		if (funcionario.isPresent()) {
//			return ResponseEntity.ok(new FuncionarioDTO(funcionario.get()));
//		}
//
//		return ResponseEntity.notFound().build();
//
//	}

	//WRITE
//		@PostMapping
//		@Transactional
//		@CacheEvict(value = "CustomersList", allEntries = true)
//		public ResponseEntity<FuncionarioDTO> registrarFuncionario(@RequestBody FuncionarioForm form,
//				UriComponentsBuilder uriBuilder) {
//
//			Funcionario funcionario = form.converterParaFuncionario();
//			funcionarioRepository.save(funcionario);
//
//			URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
//			return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
//		}
//
//		@PutMapping("/{id}")
//		@Transactional
//		public ResponseEntity<FuncionarioDTO> editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioForm form) {
//
//			Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
//			if (optionalFuncionario.isPresent()) {
//				Funcionario	funcionario = form.update(id, funcionarioRepository);
//				return ResponseEntity.ok(new FuncionarioDTO(funcionario));
//			}
//
//			return ResponseEntity.notFound().build();
//		}
//
//		@DeleteMapping("/{id}")
//		@Transactional
//		public ResponseEntity<?> excluirFuncionario(@PathVariable Long id) {
//			
//			Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
//			if (optionalFuncionario.isPresent()) {
//				funcionarioRepository.deleteById(id);
//				return ResponseEntity.ok().build();
//			}
//			
//			return ResponseEntity.notFound().build();
//		}
	
}
