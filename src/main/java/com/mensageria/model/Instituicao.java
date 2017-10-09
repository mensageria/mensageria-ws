package com.mensageria.model;

import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Instituicao extends Usuario {

	private String cnpj;

	public Instituicao() {
	}

	public Instituicao(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso, String cnpj) {
		super(email, emailConfirmado, nome, ultimoAcesso);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return super.toString() + "Instituicao [cnpj=" + cnpj + "]";
	}

}
