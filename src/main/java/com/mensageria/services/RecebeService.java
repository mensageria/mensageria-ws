package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Recebe;
import com.mensageria.repositorios.RecebeRepository;

@Service
public class RecebeService extends GenericService<Recebe> {

	@Autowired
	RecebeRepository repository;

	public Recebe receberMensagem(Recebe recebe) {
		recebe.setRecebido(true);
		return repository.save(recebe);
	}

	public Recebe visualizarMensagem(Recebe recebe) {
		recebe.setVizualizado(true);
		recebe.setRecebido(true);
		return repository.save(recebe);
	}
}
