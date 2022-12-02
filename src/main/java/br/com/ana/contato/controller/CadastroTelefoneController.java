package br.com.ana.contato.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.model.Telefone;
import br.com.ana.contato.repository.ContatoRepository;
import br.com.ana.contato.repository.TelefoneRepository;
import jakarta.validation.Valid;

@RestController
public class CadastroTelefoneController {
	
	private final ContatoRepository contatoRepository;
	
	private final TelefoneRepository telefoneRepository;

	public CadastroTelefoneController(ContatoRepository contatoRepository,
			TelefoneRepository telefoneRepository) {
		this.contatoRepository = contatoRepository;
		this.telefoneRepository = telefoneRepository;
	}
	
	@PostMapping("/contatos/{id}")
	public ResponseEntity<?> cadastrarTelefone(@PathVariable Long id, 
			@RequestBody @Valid TelefoneRequest telefoneRequest, 
			UriComponentsBuilder uriComponentsBuilder) {
		
		Contato contato = contatoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "contato não cadastrado"));
		
		Telefone novoTelefone = telefoneRequest.paraTelefoneModel();
		
		telefoneRepository.save(novoTelefone);
		
		URI location = uriComponentsBuilder.path("/contatos/{contatoId}/telefones/{id}")
				.buildAndExpand(contato.getId(), novoTelefone.getId()).toUri();
		
			return ResponseEntity.created(location).build();
		
	}
	
}
