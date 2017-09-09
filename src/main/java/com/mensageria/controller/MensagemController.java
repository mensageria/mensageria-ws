package com.mensageria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Mensagem;
import com.mensageria.services.MensagemService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class MensagemController {

	@Autowired
	MensagemService mensagemService;

	public MensagemController() {

	}
	
	@RequestMapping("/mensagens/conversa")
	public List<Mensagem> obterUltimasMensagens(@RequestParam Long chatId){
		return mensagemService.findByChatIdWithLimit(chatId, new PageRequest(1, 10));
	}

	@MessageMapping("/enviar/mensagens/conversa/{chatId}")
	@SendTo("/topic/mensagens/conversa/{chatId}")
	public Mensagem greeting(Mensagem mensagem) throws Exception {
		Mensagem novaMensagem = new Mensagem(mensagem.getConteudo(), mensagem.getDataEnvio(), mensagem.getAutor(), mensagem.getChat());
		return mensagemService.save(novaMensagem);
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
