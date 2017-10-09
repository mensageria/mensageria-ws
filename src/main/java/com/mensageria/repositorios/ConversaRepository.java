package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Conversa;


public interface ConversaRepository extends JpaRepository<Conversa, Long> {

}
