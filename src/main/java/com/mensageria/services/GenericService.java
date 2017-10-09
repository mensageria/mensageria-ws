package com.mensageria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T> {
	
	@Autowired
	JpaRepository<T, Long> repository;

	public T save(T objeto) {
		return repository.save(objeto);
	}

	public List<T> findAll() {
		return (List<T>) repository.findAll();
	}

	public T findById(Long id) {
		return (T) repository.findOne(id);
	}

	public void delete(T objeto) {
		repository.delete(objeto);
	}
}
