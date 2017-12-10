package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mensageria.model.Conversa;


public interface ConversaRepository extends JpaRepository<Conversa, Long> {

	@Query("SELECT COUNT(p) FROM Participa p WHERE p.conversa.id=:id")
    int qtdPessoasConversa(@Param("id") Long id);
	
	@Query("SELECT COUNT(m) FROM Mensagem m WHERE m.chat.id=:id")
    int qtdMensagensConversa(@Param("id") Long id);
}
