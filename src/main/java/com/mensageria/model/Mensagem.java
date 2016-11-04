package com.mensageria.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mensagens")
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String conteudo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEnvio;

	@ManyToOne
	private Usuario autor;

	@ManyToOne
	private Conversa conversa;

	public Mensagem() {
	}

	public Mensagem(String conteudo, Calendar dataEnvio, Usuario autor, Conversa conversa) {
		super();
		this.conteudo = conteudo;
		this.dataEnvio = dataEnvio;
		this.autor = autor;
		this.conversa = conversa;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Calendar getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Calendar dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Conversa getConversa() {
		return conversa;
	}

	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", conteudo=" + conteudo + ", dataEnvio=" + dataEnvio + ", autor=" + autor
				+ ", conversa=" + conversa + "]";
	}

}
