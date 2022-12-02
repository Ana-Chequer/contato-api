package br.com.ana.contato.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.model.TipoCadastro;
import br.com.ana.contato.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class AtualizacaoContatoController {
	
	private final ContatoRepository contatoRepository;

	public AtualizacaoContatoController(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@Transactional
	@PutMapping("contatos/{id}")
	public ResponseEntity<?> atualizarContato(@PathVariable Long id, 
			@RequestBody @Valid ContatoAtualizacaoRequest contatoAtualizacaoRequest) {
		
		Contato contato = contatoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
							
		if(contato.getTipoCadastro().equals(TipoCadastro.INATIVO)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Contato inativo não pode ser alterado");
		}		
		
		Contato contatoAtualizado = contatoAtualizacaoRequest.paraContatoAtualizado(contato);
		
		contatoRepository.save(contatoAtualizado);
		
		return ResponseEntity.noContent().build();
		
	}
	
	

}
