package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Dispositivo;


public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>{
	
}
