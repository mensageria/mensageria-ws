package com.mensageria.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mensageria.interfaces.MetodosUsuario;
import com.mensageria.model.Dispositivo;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;
import com.mensageria.services.DispositivoService;
import com.mensageria.services.UsuarioService;
import com.mensageria.util.CalendarDeserializer;

@RestController
public class ControllerUsuario implements MetodosUsuario {

	@Autowired
	DispositivoService dispositivoService;

	@Autowired
	UsuarioService usuarioService;

	public ControllerUsuario() {
		super();
	}

	@Override
	public void ConfirmarVizualizacaoMensagem(Usuario usuario, Mensagem mensagem) {

	}

	@Override
	public List<Mensagem> ReceberMensagem(Usuario usuario) {
		return null;
	}

	@CrossOrigin()
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	@Override
	public Dispositivo registrar(@RequestBody String json) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Calendar.class, new CalendarDeserializer());
		Gson gson = builder.create();

		Dispositivo dispositivo = gson.fromJson(json, Dispositivo.class);
		dispositivo.getProprietario().setUltimoAcesso(Calendar.getInstance());
		dispositivo.setProprietario(this.usuarioService.save(dispositivo.getProprietario()));
		return this.dispositivoService.save(dispositivo);
	}

	// TODO mudar metodo de teste
	@CrossOrigin()
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Dispositivo> getAllDispositivos() {
		return this.dispositivoService.findAll();
	}
}
