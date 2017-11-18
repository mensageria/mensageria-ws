package com.mensageria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Conversa conversa;
	
	public Participa(Usuario usuario, Conversa conversa) {
		super();
		this.usuario = usuario;
		this.conversa = conversa;
	}
	public Participa() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
}
