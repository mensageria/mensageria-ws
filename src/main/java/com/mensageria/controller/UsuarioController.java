package com.mensageria.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.interfaces.MetodosUsuario;
import com.mensageria.model.Dispositivo;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;
import com.mensageria.services.DispositivoService;
import com.mensageria.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioController implements MetodosUsuario {

	@Autowired
	DispositivoService dispositivoService;

	@Autowired
	UsuarioService usuarioService;

	public UsuarioController() {
		super();
	}

	@Override
	public void ConfirmarVizualizacaoMensagem(Usuario usuario, Mensagem mensagem) {

	}

	@Override
	public List<Mensagem> ReceberMensagem(Usuario usuario) {
		return null;
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	@Override
	public Dispositivo registrar(@RequestBody Dispositivo dispositivo) {
		dispositivo.setPushToken(dispositivoService.gerarToken());

		Calendar dataAtual = Calendar.getInstance();
		dispositivo.setDataRegistro(dataAtual);
		dispositivo.getProprietario().setUltimoAcesso(dataAtual);
		dispositivo.getProprietario().setPrioridade(0);

		dispositivo.setProprietario(this.usuarioService.save(dispositivo.getProprietario()));

		return this.dispositivoService.save(dispositivo);
	}

	// TODO mudar metodo de teste
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Dispositivo> getAllDispositivos() {
		return this.dispositivoService.findAll();
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.POST)
	public List<Usuario> cadastrarUsuarios(@RequestBody List<Usuario> usuarios) {
		List<Usuario> usuarioCadastrados = new ArrayList<Usuario>();
		for (Usuario usuario : usuarios) {
			usuarioCadastrados.add(usuarioService.save(usuario));
		}

		return usuarioCadastrados;
	}

	@RequestMapping("/usuarios/{usuarioId}")
	public Usuario getUsuario(@PathVariable Long usuarioId) {
		return usuarioService.findById(usuarioId);
	}
}
