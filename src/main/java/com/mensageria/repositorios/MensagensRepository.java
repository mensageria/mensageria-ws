package com.mensageria.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Mensagem;

@RepositoryRestResource(collectionResourceRel = "Mensagem", path = "mensagens")
public interface MensagensRepository extends PagingAndSortingRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutorEmail(@Param("email") String email);
}