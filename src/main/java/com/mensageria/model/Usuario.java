package com.mensageria.model;

import java.util.Calendar;
import java.util.List;

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
	private Long id;
	private String email;
	private boolean emailConfirmado;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoAcesso;

	@OneToMany
	private List<Dispositivo> listaDispositivos;

	@OneToMany
	private List<Mensagem> listaMensagens;

	@OneToMany
	private List<Confirmacao> listaConfirmacoes;

	public Usuario() {
	}

	public Usuario(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso) {
		super();
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.nome = nome;
		this.ultimoAcesso = ultimoAcesso;
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

	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
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
		return "Usuario [id=" + id + ", email=" + email + ", emailConfirmado=" + emailConfirmado + ", nome=" + nome
				+ ", ultimoAcesso=" + ultimoAcesso + ", listaDispositivos=" + listaDispositivos + ", listaMensagens="
				+ listaMensagens + ", listaConfirmacoes=" + listaConfirmacoes + "]";
	}

}
