package com.mensageria.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mensageria.model.Usuario;

@RepositoryRestResource(collectionResourceRel = "Usuario", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

}
