package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Dispositivo;
import com.mensageria.repositorios.DispositivoRepository;

@Service
public class DispositivoService extends GenericService<Dispositivo> {

	@Autowired
	DispositivoRepository repository;
}
