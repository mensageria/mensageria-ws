package com.mensageria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Conversa;
import com.mensageria.services.ConversaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ConversaController {

	@Autowired
	ConversaService conversaService;
	
	@RequestMapping(value = "/conversas", method = RequestMethod.GET)
	public List<Conversa> getAllConversas() {
		return conversaService.findAll();
	}
	
	@RequestMapping(value = "/conversas", method = RequestMethod.POST)
	public Conversa cadastrarConversa(@RequestBody Conversa conversa) {
		return conversaService.save(conversa);
	}
}
