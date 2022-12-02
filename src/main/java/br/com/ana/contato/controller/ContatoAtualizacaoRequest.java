package br.com.ana.contato.controller;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.model.TipoCadastro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContatoAtualizacaoRequest {
	
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String empresa;
	
	public ContatoAtualizacaoRequest(String nome, String empresa) {
		this.nome = nome;
		this.empresa = empresa;
		
	}
	
	public Contato paraContatoAtualizado(Contato contato) {
		Contato contatoAtualizado = contato;
		contatoAtualizado.setNome(nome);
		contatoAtualizado.setEmpresa(empresa);
				
		return contatoAtualizado;
	}

}
