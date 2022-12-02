package br.com.ana.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ana.contato.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>  {

}
