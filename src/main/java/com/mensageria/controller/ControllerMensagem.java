package com.mensageria.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		    Mensagem pj = new Mensagem();
		    ObjectMapper mapper = new ObjectMapper();
		    try {
				pj = mapper.readValue(json, Mensagem.class);
				//listaMensagens.add(pj);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    //do some things with json, put some header information in json
		    try {
				return mapper.writeValueAsString(pj);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    return null;
		}
}
