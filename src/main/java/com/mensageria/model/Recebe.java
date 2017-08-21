package com.mensageria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recebe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean vizualizado;
	private boolean recebido;

	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Mensagem mensagem;

	public Recebe() {
	}

	public Recebe(Long id, boolean vizualizado, boolean recebido,
			Usuario usuario, Mensagem mensagem) {
		this.id = id;
		this.vizualizado = vizualizado;
		this.recebido = recebido;
		this.usuario = usuario;
		this.mensagem = mensagem;
	}



	public boolean isVizualizado() {
		return vizualizado;
	}

	public void setVizualizado(boolean vizualizado) {
		this.vizualizado = vizualizado;
	}

	public boolean isRecebido() {
		return recebido;
	}

	public void setRecebido(boolean recebido) {
		this.recebido = recebido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Long getId() {
		return id;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}



}
