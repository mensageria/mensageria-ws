package com.mensageria.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivos")
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String pushToken;
	private Calendar dataRegistro;
	
	@ManyToOne
	private Usuario proprietario;
	
	public Dispositivo() {
	}

	public Dispositivo(String nome, String pushToken, Calendar dataRegistro, Usuario proprietario) {
		super();
		this.nome = nome;
		this.pushToken = pushToken;
		this.dataRegistro = dataRegistro;
		this.proprietario = proprietario;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public Long getId() {
		return id;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
	
}
