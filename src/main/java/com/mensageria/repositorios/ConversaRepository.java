package com.mensageria.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Conversa;

@RepositoryRestResource(collectionResourceRel = "Conversa", path = "conversas")
public interface ConversaRepository extends PagingAndSortingRepository<Conversa, Long> {

}
