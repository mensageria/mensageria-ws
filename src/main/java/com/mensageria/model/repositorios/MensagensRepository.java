package com.mensageria.model.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

public interface MensagensRepository extends CrudRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutor(Usuario autor);
}