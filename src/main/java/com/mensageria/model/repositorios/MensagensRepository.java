package com.mensageria.model.repositorios;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

public interface MensagensRepository extends CrudRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutor(Usuario autor);
    List<Mensagem> findByDataEnvio(Calendar dataEnvio);
}