package com.mensageria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mensageria.interfaces.MetodosCliente;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

@RestController
public class ControllerCliente implements MetodosCliente {

	public ControllerCliente() {
		super();
	}

	@Override
	public void ConfirmarMensagem(Usuario cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mensagem ReceberMensagem(Usuario cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean TemMensagem(Usuario cliente) {
		// TODO Auto-generated method stub
		return false;
	}
}
