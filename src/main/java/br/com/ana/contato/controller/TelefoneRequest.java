package br.com.ana.contato.controller;

import br.com.ana.contato.model.Contato;
import br.com.ana.contato.model.Telefone;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelefoneRequest {

	@NotBlank
	private String tipo;
	
	@NotBlank
	private String numero;
	
	public TelefoneRequest(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Telefone paraTelefoneModel() {
		return new Telefone(tipo, numero);
	}
	

}
