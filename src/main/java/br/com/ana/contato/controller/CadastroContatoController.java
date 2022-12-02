package br.com.ana.contato.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.repository.ContatoRepository;
import jakarta.validation.Valid;

@RestController
public class CadastroContatoController {
	
	private final ContatoRepository contatoRepository;

	public CadastroContatoController(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@PostMapping("/contatos")
	public ResponseEntity<?> cadastrarContato(@RequestBody @Valid ContatoRequest contatoRequest, 
			UriComponentsBuilder uriComponentsBuilder) {
		
		Contato novoContato = contatoRequest.paraContatoModel();
		
		contatoRepository.save(novoContato);
		
		URI location = uriComponentsBuilder.path("/contatos/{id}")
				.buildAndExpand(novoContato.getId()).toUri();
		
				return ResponseEntity.created(location).build();
		
	}

}
