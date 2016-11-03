package com.mensageria.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Usuario;

@RestController
public class ControllerCliente {

	ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();

	public ControllerCliente() {
		super();
	}

	@CrossOrigin()
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ArrayList<Usuario> getAllUsuarios() {

		return listaClientes;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable("id") int id) {

		return listaClientes.get(id);
	}

}
