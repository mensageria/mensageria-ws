package com.mensageria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecebePk implements Serializable {

	private static final long serialVersionUID = -6314738727677901466L;

	@Column(name = "mensagem_id")
	Long mensagem;

	@Column(name = "usuario_id")
	Long usuario;

	public RecebePk() {
		super();
	}

	public Long getMensagem() {
		return mensagem;
	}

	public void setMensagem(Long mensagem) {
		this.mensagem = mensagem;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

}
