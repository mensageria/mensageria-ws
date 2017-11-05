package com.mensageria;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mensageria.model.Conversa;
import com.mensageria.model.Dispositivo;
import com.mensageria.model.Instituicao;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;
import com.mensageria.services.ConversaService;
import com.mensageria.services.DispositivoService;
import com.mensageria.services.MensagemService;
import com.mensageria.services.UsuarioService;

@SpringBootApplication
public class MensageriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

	@Bean
	public String popularBanco(MensagemService serviceMensagem, UsuarioService serviceUsuario,
			ConversaService serviceConversa, DispositivoService serviceDispositivo) {

		if (!serviceUsuario.findAll().isEmpty()) {
			return "banco ja foi populado";
		}

		serviceUsuario.save(new Usuario("email", true, "nome", Calendar.getInstance()));
		serviceUsuario.save(new Instituicao("email 2", true, "nome 2", Calendar.getInstance(), "cnpj"));

		serviceConversa.save(new Conversa(true, "conversa", Calendar.getInstance()));
		serviceConversa.save(new Conversa(false, "conversa 2", Calendar.getInstance()));

		serviceDispositivo.save(new Dispositivo("mac", "nome", "token", serviceUsuario.findAll().get(0)));
		serviceDispositivo.save(new Dispositivo("mac2", "nome2", "token", serviceUsuario.findAll().get(0)));

		serviceMensagem.save(new Mensagem("conteudo", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(0)));
		serviceMensagem.save(new Mensagem("conteudo 2", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(1)));
		serviceMensagem.save(new Mensagem("conteudo 3", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(0)));
		
		return "banco populado";
	}
}
