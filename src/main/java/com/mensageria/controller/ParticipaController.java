package com.mensageria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.Participa;
import com.mensageria.services.ParticipaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ParticipaController {
	@Autowired
	ParticipaService participaService;	
	
	
	@RequestMapping(value = "/participa", method = RequestMethod.POST)
	public List<Participa> cadastrarUsuarios(@RequestBody List<Participa> participantes) {
		List<Participa> participantesCriados = new ArrayList<Participa>();
		for (Participa participante : participantes) {
			participantesCriados.add(participaService.save(participante));
		}

		return participantesCriados;
	}
}
