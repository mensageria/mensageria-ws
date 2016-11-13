package com.mensageria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Mensagem;
import com.mensageria.repositorios.MensagemRepository;

@Service
public class MensagemService {
	@Autowired
	MensagemRepository mensagemRepository;

	public void save(Mensagem mensagem) {
		mensagemRepository.save(mensagem);
	}

	public List<Mensagem> findAll() {
		return (List<Mensagem>) mensagemRepository.findAll();
	}

	public Mensagem findByID(Long id) {
		return mensagemRepository.findOne(id);
	}

	public void delete(Mensagem mensagem) {
		mensagemRepository.delete(mensagem);
	}

	public List<Mensagem> findByAutorEmail(String email) {
		return mensagemRepository.findByAutorEmail(email);
	}
}
