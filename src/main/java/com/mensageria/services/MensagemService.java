package com.mensageria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mensageria.model.Mensagem;
import com.mensageria.repositorios.MensagemRepository;

@Service
public class MensagemService extends GenericService<Mensagem> {

	@Autowired
	MensagemRepository repository;

	public List<Mensagem> findByAutorEmail(String email) {
		return repository.findByAutorEmail(email);
	}

	public List<Mensagem> findByChatId(Long chatId) {
		return repository.findByChatId(chatId);
	}

	public List<Mensagem> findByChatIdWithLimit(Long chatId, Pageable pageable) {
		return repository.findTop20ByChatIdOrderById(chatId, pageable);
	}
}
