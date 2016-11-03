package com.mensageria.model;

import java.util.Calendar;
import java.util.TreeSet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Instituicao extends Usuario {

	private String cnpj;

	public Instituicao() {
	}

	public Instituicao(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso,
			TreeSet<Dispositivo> listaDispositivos, TreeSet<Mensagem> listaMensagens,
			TreeSet<Confirmacao> listaConfirmacoes, String cnpj) {
		super(email, emailConfirmado, nome, ultimoAcesso, listaDispositivos, listaMensagens, listaConfirmacoes);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return super.toString() + "Instituicao [cnpj=" + cnpj + "]";
	}

	
	

}
