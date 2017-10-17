package com.mensageria.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	
    List<Mensagem> findByAutorEmail(String email);
    List<Mensagem> findByChatId(Long conversaId);
    List<Mensagem> findTop20ByChatIdOrderById(Long conversaId, Pageable pageable);
}