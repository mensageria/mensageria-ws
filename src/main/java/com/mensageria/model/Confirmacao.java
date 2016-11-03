package com.mensageria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "confirmacoes")
public class Confirmacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean vizualizado;
	private boolean recebido;

	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Conversa conversa;

	public Confirmacao() {
	}

	public Confirmacao(boolean vizualizado, boolean recebido, Usuario usuario, Conversa conversa) {
		this.vizualizado = vizualizado;
		this.recebido = recebido;
		this.usuario = usuario;
		this.conversa = conversa;
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

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Confirmacao [id=" + id + ", vizualizado=" + vizualizado + ", recebido=" + recebido + ", usuario="
				+ usuario + ", conversa=" + conversa + "]";
	}

}
