package com.mensageria.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Dispositivo;

@RepositoryRestResource(collectionResourceRel = "Dispositivo", path = "dispositivos")
public interface DispositivoRepository extends PagingAndSortingRepository<Dispositivo, Long>{
	
}
