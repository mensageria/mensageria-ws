package com.mensageria.interfaces;

import java.util.List;

import com.mensageria.model.Dispositivo;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

public interface MetodosUsuario {

	void ConfirmarVizualizacaoMensagem(Usuario usuario, Mensagem mensagem);

	List<Mensagem> ReceberMensagem(Usuario usuario);

	Dispositivo registrar(Dispositivo dispositivo);

}