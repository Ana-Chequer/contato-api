package br.com.ana.contato.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String empresa;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "contato")
	private List<Telefone> telefones = new ArrayList<>();
	
	private TipoCadastro tipoCadastro;

	public Contato(String nome, String empresa, TipoCadastro tipoCadastro) {
		this.nome = nome;
		this.empresa = empresa;
		this.tipoCadastro = tipoCadastro;	
	}
	
	public void adicionar(Telefone telefone) {
		this.telefones.add(telefone);
		telefone.setContato(this);
	}
	
}
