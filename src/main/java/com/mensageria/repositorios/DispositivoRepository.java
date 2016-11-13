package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Dispositivo;

@RepositoryRestResource(exported=false)
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>{
	
}
