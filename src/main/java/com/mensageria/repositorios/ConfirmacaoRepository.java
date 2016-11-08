package com.mensageria.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Confirmacao;

@RepositoryRestResource(collectionResourceRel = "Confirmacao", path = "confirmacoes")
public interface ConfirmacaoRepository extends PagingAndSortingRepository<Confirmacao, Long>{
	
}
