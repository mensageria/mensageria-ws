package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Participa;
import com.mensageria.repositorios.ParticipaRepository;

@Service
public class ParticipaService extends GenericService<Participa> {

	@Autowired
	ParticipaRepository repository;
}
