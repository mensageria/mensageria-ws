package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Participa;


public interface ParticipaRepository extends JpaRepository<Participa, Long> {
	
}
