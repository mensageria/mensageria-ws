package com.mensageria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Conversa;
import com.mensageria.repositorios.ConversaRepository;

@Service
public class ConversaService extends GenericService<Conversa> {

	@Autowired
	ConversaRepository repository;
	
	public Conversa findOne(Long id) {
		Conversa tempConversa = repository.findOne(id);
		return tempConversa;
	}
	
	public List<Conversa> findAll(){
		List<Conversa> conversas = repository.findAll();
		
		return conversas;
	}
}
