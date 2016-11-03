package com.mensageria.model;

import java.util.Calendar;
import java.util.TreeSet;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
@Inheritance
@DiscriminatorColumn(name = "tipo_usuario")
@DiscriminatorValue("U")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private boolean emailConfirmado;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoAcesso;

	@OneToMany
	private TreeSet<Dispositivo> listaDispositivos;

	@OneToMany
	private TreeSet<Mensagem> listaMensagens;

	@OneToMany
	private TreeSet<Confirmacao> listaConfirmacoes;

	public Usuario() {
	}

	public Usuario(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso,
			TreeSet<Dispositivo> listaDispositivos, TreeSet<Mensagem> listaMensagens,
			TreeSet<Confirmacao> listaConfirmacoes) {
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.nome = nome;
		this.ultimoAcesso = ultimoAcesso;
		this.listaDispositivos = listaDispositivos;
		this.listaMensagens = listaMensagens;
		this.listaConfirmacoes = listaConfirmacoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailConfirmado() {
		return emailConfirmado;
	}

	public void setEmailConfirmado(boolean emailConfirmado) {
		this.emailConfirmado = emailConfirmado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Calendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public TreeSet<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(TreeSet<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
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
		return "Usuario [id=" + id + ", email=" + email + ", emailConfirmado=" + emailConfirmado + ", nome=" + nome
				+ ", ultimoAcesso=" + ultimoAcesso + ", listaDispositivos=" + listaDispositivos + ", listaMensagens="
				+ listaMensagens + ", listaConfirmacoes=" + listaConfirmacoes + "]";
	}

	
}
