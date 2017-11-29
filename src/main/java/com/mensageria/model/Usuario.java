package com.mensageria.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
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
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String email;
	private boolean emailConfirmado;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoAcesso;

	private int prioridade;

	@JsonIgnore
	@OneToMany(mappedBy = "proprietario")
	private List<Dispositivo> listaDispositivos;

	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<Mensagem> listaMensagensEnviadas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Recebe> listaRecebidas;

	public Usuario() {
	}

	public Usuario(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso, int prioridade) {
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.nome = nome;
		this.ultimoAcesso = ultimoAcesso;
		this.prioridade = prioridade;
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

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	public List<Mensagem> getListaMensagensEnviadas() {
		return listaMensagensEnviadas;
	}

	public void setListaMensagensEnviadas(List<Mensagem> listaMensagensEnviadas) {
		this.listaMensagensEnviadas = listaMensagensEnviadas;
	}

	public List<Recebe> getListaRecebidas() {
		return listaRecebidas;
	}

	public void setListaRecebidas(List<Recebe> listaRecebidas) {
		this.listaRecebidas = listaRecebidas;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", emailConfirmado=" + emailConfirmado + ", nome=" + nome
				+ ", ultimoAcesso=" + ultimoAcesso.getTime() + "]";
	}

}
