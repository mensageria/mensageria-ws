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

	@OneToMany
	private List<Mensagem> listaMensagens;

	@OneToMany
	private List<Confirmacao> listaConfirmacoes;

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

	public List<Confirmacao> getListaConfirmacoes() {
		return listaConfirmacoes;
	}

	public void setListaConfirmacoes(List<Confirmacao> listaConfirmacoes) {
		this.listaConfirmacoes = listaConfirmacoes;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Conversa [id=" + id + ", interativa=" + interativa + ", nome=" + nome + ", dataCriação=" + dataCriação
				+ ", listaMensagens=" + listaMensagens + ", listaConfirmacoes=" + listaConfirmacoes + "]";
	}

}
