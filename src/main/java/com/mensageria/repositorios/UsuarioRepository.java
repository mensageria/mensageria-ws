package com.mensageria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensageria.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
