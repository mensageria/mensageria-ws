package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Conversa;
import com.mensageria.repositorios.ConversaRepository;

@Service
public class ConversaService extends GenericService<Conversa> {

	@Autowired
	ConversaRepository repository;
}
