package br.com.ana.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ana.contato.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long
>  {

}
