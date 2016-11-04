package com.mensageria.model;

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
	private String mac;
	private String nome;
	private String tokenFirebase;
	
	@ManyToOne
	private Usuario proprietario;
	
	public Dispositivo() {
	}

	public Dispositivo(String mac, String nome, String tokenFirebase, Usuario proprietario) {
		this.mac = mac;
		this.nome = nome;
		this.tokenFirebase = tokenFirebase;
		this.proprietario = proprietario;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTokenFirebase() {
		return tokenFirebase;
	}

	public void setTokenFirebase(String tokenFirebase) {
		this.tokenFirebase = tokenFirebase;
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

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", mac=" + mac + ", nome=" + nome + ", tokenFirebase=" + tokenFirebase
				+ ", proprietario=" + proprietario + "]";
	}
	
	
}
