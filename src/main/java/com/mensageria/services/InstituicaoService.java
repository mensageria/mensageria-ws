package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Instituicao;
import com.mensageria.repositorios.InstituicaoRepository;

@Service
public class InstituicaoService extends GenericService<Instituicao> {

	@Autowired
	InstituicaoRepository repository;
}
