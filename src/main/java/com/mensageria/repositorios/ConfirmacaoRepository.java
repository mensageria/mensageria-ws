package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Recebe;

@RepositoryRestResource(exported=false)
public interface ConfirmacaoRepository extends JpaRepository<Recebe, Long>{
	
}
