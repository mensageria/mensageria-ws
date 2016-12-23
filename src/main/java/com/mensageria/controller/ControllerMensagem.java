package com.mensageria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Mensagem;
import com.mensageria.services.MensagemService;

@RestController
public class ControllerMensagem {
	
	@Autowired
	MensagemService mensagemService;
	
	public ControllerMensagem(){

	}
		@CrossOrigin()
		@RequestMapping(value = "/mensagens", method = RequestMethod.GET)
		public List<Mensagem> getAllMensagens() {
			return mensagemService.findAll();
		}
	
		@CrossOrigin()
		@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.GET)
		public Mensagem getMensagem(@PathVariable("id") Long id) {
			return mensagemService.findByID(id);
		}
		
		@CrossOrigin()
		@RequestMapping(value = "/post", method = RequestMethod.POST, produces="application/json", consumes="application/json")
		@ResponseBody
		public String post(@RequestBody String json) {
		 
		    return null;
		}
}
