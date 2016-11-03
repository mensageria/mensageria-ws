package com.mensageria.interfaces;

import java.util.ArrayList;

import com.mensageria.model.Conversa;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;

public interface InterfaceEmpresa {

	Conversa EnviarMensagem(ArrayList<Usuario> listaIDs, Mensagem mensagem);

	ArrayList<Usuario> VerificarLidos(Conversa conversa);

	ArrayList<Usuario> VerificarNaoLidos(Conversa conversa);

	ArrayList<Usuario> VerificarNaoRecebidos(Conversa conversa);
	
	ArrayList<Usuario> getClientes();

}
