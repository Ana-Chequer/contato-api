package br.com.ana.contato.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.model.Telefone;
import br.com.ana.contato.model.TipoCadastro;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContatoRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String empresa;
	
	List<TelefoneRequest> telefonesRequest = new ArrayList<>();
	
	private String tipoCadastro;
	
	public ContatoRequest(String nome, String empresa, String tipoCadastro, List<TelefoneRequest> telefonesRequest) {
		this.nome = nome;
		this.empresa = empresa;
		this.tipoCadastro = tipoCadastro;
		this.telefonesRequest = telefonesRequest;
	}
	
	public Contato paraContatoModel() {
		
		Contato contato = new Contato(nome, empresa, TipoCadastro.get(this.tipoCadastro));
		
		this.telefonesRequest.stream().forEach(t-> {
			Telefone telefone = t.paraTelefoneModel();
			contato.adicionar(telefone);
		});
		
		return contato;
	}

}
