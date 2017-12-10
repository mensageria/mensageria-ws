package com.mensageria.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recebe implements Serializable {

	private static final long serialVersionUID = 8356627478278485922L;

	@EmbeddedId
	private RecebePk id;

	private boolean visualizado;
	private boolean recebido;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Usuario usuario;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Mensagem mensagem;

	public Recebe() {
	}

	public Recebe(boolean visualizado, boolean recebido, Usuario usuario, Mensagem mensagem) {
		this.visualizado = visualizado;
		this.recebido = recebido;
		this.usuario = usuario;
		this.mensagem = mensagem;
	}



	public boolean isVisualizado() {
		return visualizado;
	}

	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
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

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public RecebePk getId() {
		return id;
	}

	public void setId(RecebePk id) {
		this.id = id;
	}

}
