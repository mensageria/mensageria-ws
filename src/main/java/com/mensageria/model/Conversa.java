package com.mensageria.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mensagens")
public class Conversa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private boolean interativa;
	private ArrayList<Usuario> participantes;
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriação;

	@OneToMany
	private TreeSet<Mensagem> listaMensagens;

	@OneToMany
	private TreeSet<Confirmacao> listaConfirmacoes;

	public Conversa() {
	}

	public Conversa(boolean interativa, ArrayList<Usuario> participantes, String nome, Calendar dataCriação,
			TreeSet<Mensagem> listaMensagens, TreeSet<Confirmacao> listaConfirmacoes) {
		this.interativa = interativa;
		this.participantes = participantes;
		this.nome = nome;
		this.dataCriação = dataCriação;
		this.listaMensagens = listaMensagens;
		this.listaConfirmacoes = listaConfirmacoes;
	}

	public boolean isInterativa() {
		return interativa;
	}

	public void setInterativa(boolean interativa) {
		this.interativa = interativa;
	}

	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Usuario> participantes) {
		this.participantes = participantes;
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

	public TreeSet<Mensagem> getListaMensagens() {
		return listaMensagens;
	}

	public void setListaMensagens(TreeSet<Mensagem> listaMensagens) {
		this.listaMensagens = listaMensagens;
	}

	public TreeSet<Confirmacao> getListaConfirmacoes() {
		return listaConfirmacoes;
	}

	public void setListaConfirmacoes(TreeSet<Confirmacao> listaConfirmacoes) {
		this.listaConfirmacoes = listaConfirmacoes;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Conversa [id=" + id + ", interativa=" + interativa + ", participantes=" + participantes + ", nome="
				+ nome + ", dataCriação=" + dataCriação + ", listaMensagens=" + listaMensagens + ", listaConfirmacoes="
				+ listaConfirmacoes + "]";
	}

}
