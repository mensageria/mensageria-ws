package com.mensageria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensageria.model.Usuario;
import com.mensageria.repositorios.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario save(Usuario objeto) {
		Usuario usuarioExistente = repository.findByEmail(objeto.getEmail());
		if (usuarioExistente != null) {
			return usuarioExistente;
		} else {
			return repository.save(objeto);
		}
	}
}
