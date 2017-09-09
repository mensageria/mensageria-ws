package com.mensageria.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.interfaces.MetodosEmpresa;
import com.mensageria.model.Conversa;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

@RestController
@RequestMapping("/api")
public class EmpresaController implements MetodosEmpresa {
	
	@Override
	public Conversa EnviarMensagem(ArrayList<Usuario> listaIDs, Mensagem mensagem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> VerificarLidos(Conversa conversa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> VerificarNaoLidos(Conversa conversa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> VerificarNaoRecebidos(Conversa conversa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

}
