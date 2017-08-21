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
	private Calendar dataCriação;

	@JsonIgnore
	@OneToMany(mappedBy = "chat")
	private List<Mensagem> listaMensagens;
	
	@JsonIgnore
	@OneToMany(mappedBy = "conversa")
	private List<Participa> listaParticipacoes;
	

	public Conversa() {
	}

	public Conversa(boolean interativa, String nome, Calendar dataCriação) {
		super();
		this.interativa = interativa;
		this.nome = nome;
		this.dataCriação = dataCriação;
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

	public Calendar getDataCriação() {
		return dataCriação;
	}

	public void setDataCriação(Calendar dataCriação) {
		this.dataCriação = dataCriação;
	}

	public List<Mensagem> getListaMensagens() {
		return listaMensagens;
	}

	public void setListaMensagens(List<Mensagem> listaMensagens) {
		this.listaMensagens = listaMensagens;
	}


	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Conversa [id=" + id + ", interativa=" + interativa + ", nome=" + nome + ", dataCriação=" + dataCriação.getTime()
				+ "]";
	}

	public List<Participa> getListaParticipacoes() {
		return listaParticipacoes;
	}

	public void setListaParticipacoes(List<Participa> listaParticipacoes) {
		this.listaParticipacoes = listaParticipacoes;
	}
	

}
