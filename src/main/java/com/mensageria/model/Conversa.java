package com.mensageria.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "conversas")
public class Conversa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean interativa;
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@JsonIgnore
	@OneToMany(mappedBy = "chat")
	private List<Mensagem> listaMensagens;

	@JsonIgnore
	@OneToMany(mappedBy = "conversa")
	private List<Participa> listaParticipacoes;

	public Conversa() {
	}
	
	public Conversa(boolean interativa, String nome, Calendar dataCriacao) {
		super();
		this.interativa = interativa;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQtdPessoas() {
		return this.listaParticipacoes.size();
	}

	public boolean isInterativa() {
		return interativa;
	}

	public void setInterativa(boolean interativa) {
		this.interativa = interativa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Mensagem> getListaMensagens() {
		return listaMensagens;
	}

	public void setListaMensagens(List<Mensagem> listaMensagens) {
		this.listaMensagens = listaMensagens;
	}

	public List<Participa> getListaParticipacoes() {
		return listaParticipacoes;
	}

	public void setListaParticipacoes(List<Participa> listaParticipacoes) {
		this.listaParticipacoes = listaParticipacoes;
	}

	public int getQtdMensagens() {
		return this.listaMensagens.size();
	}

}
