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
import com.mensageria.model.Recebe;
import com.mensageria.services.MensagemService;
import com.mensageria.services.RecebeService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class MensagemController {

	@Autowired
	MensagemService mensagemService;
	
	@Autowired
	RecebeService recebeService;
	
	@RequestMapping("/mensagens/conversa")
	public List<Mensagem> obterUltimasMensagens(@RequestParam Long chatId){
		return mensagemService.findByChatIdWithLimit(chatId, new PageRequest(1, 10));
	}
	
	@RequestMapping(value = "/mensagens", method = RequestMethod.GET)
	public List<Mensagem> getAllMensagens() {
		return mensagemService.findAll();
	}

	@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.GET)
	public Mensagem getMensagem(@PathVariable("id") Long id) {
		return mensagemService.findById(id);
	}

	@MessageMapping("/enviar/mensagens/conversa/{chatId}")
	@SendTo("/topic/mensagens/conversa/{chatId}")
	public Mensagem enviar(Mensagem mensagem) throws Exception {
		return mensagemService.save(mensagem);
	}
	
	@MessageMapping("/receber/mensagens/conversa/{chatId}")
	@SendTo("/topic/mensagens/conversa/{chatId}")
	public Recebe confirmarRecebimento(Recebe recebe) throws Exception {
		return recebeService.receberMensagem(recebe);
	}
	
	@MessageMapping("/visualizar/mensagens/conversa/{chatId}")
	@SendTo("/topic/mensagens/conversa/{chatId}")
	public Recebe confirmarVisualizacao(Recebe recebe) throws Exception {
		return recebeService.visualizarMensagem(recebe);
	}

}
