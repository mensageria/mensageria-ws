package com.mensageria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Mensagem;
import com.mensageria.repositorios.MensagemRepository;

@Service
public class MensagemService extends GenericService<Mensagem>{
	
	@Autowired
	MensagemRepository repository;

	public List<Mensagem> findByAutorEmail(String email) {
		return repository.findByAutorEmail(email);
	}
}
