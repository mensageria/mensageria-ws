package com.mensageria.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutorEmail(String email);
}