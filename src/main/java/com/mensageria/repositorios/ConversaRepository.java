package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Conversa;

@RepositoryRestResource(exported=false)
public interface ConversaRepository extends JpaRepository<Conversa, Long> {

}
