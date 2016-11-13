package com.mensageria.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Mensagem;

@RepositoryRestResource(exported=false)
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutorEmail(String email);
}