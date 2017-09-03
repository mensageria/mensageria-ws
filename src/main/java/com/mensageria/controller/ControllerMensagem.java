package com.mensageria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Mensagem;
import com.mensageria.services.MensagemService;

@CrossOrigin()
@RestController
public class ControllerMensagem {

	@Autowired
	MensagemService mensagemService;

	public ControllerMensagem() {

	}

	@RequestMapping(value = "/mensagens", method = RequestMethod.GET)
	public List<Mensagem> getAllMensagens() {
		return mensagemService.findAll();
	}

	@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.GET)
	public Mensagem getMensagem(@PathVariable("id") Long id) {
		return mensagemService.findById(id);
	}
}
