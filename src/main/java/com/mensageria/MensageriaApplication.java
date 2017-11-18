package com.mensageria;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mensageria.model.Conversa;
import com.mensageria.model.Dispositivo;
import com.mensageria.model.Instituicao;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Participa;
import com.mensageria.model.Usuario;
import com.mensageria.services.ConversaService;
import com.mensageria.services.DispositivoService;
import com.mensageria.services.MensagemService;
import com.mensageria.services.ParticipaService;
import com.mensageria.services.UsuarioService;

@SpringBootApplication
public class MensageriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

	@Bean
	public String popularBanco(MensagemService serviceMensagem, UsuarioService serviceUsuario,
			ConversaService serviceConversa, DispositivoService serviceDispositivo, ParticipaService serviceParticipa) {

		if (!serviceUsuario.findAll().isEmpty()) {
			return "banco ja foi populado";
		}

		serviceUsuario.save(new Usuario("allison@g.com", true, "Allison", Calendar.getInstance()));
		serviceUsuario.save(new Usuario("renan@g.com", true, "Renan", Calendar.getInstance()));
		serviceUsuario.save(new Usuario("gabriel@g.com", true, "Gabriel", Calendar.getInstance()));
		serviceUsuario.save(new Instituicao("email 2", true, "nome 2", Calendar.getInstance(), "cnpj"));

		serviceConversa.save(new Conversa(true, "conversa 1", Calendar.getInstance()));
		serviceConversa.save(new Conversa(true, "conversa 2", Calendar.getInstance()));
		serviceConversa.save(new Conversa(false, "conversa 3", Calendar.getInstance()));
		
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(0), serviceConversa.findAll().get(0)));
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(1), serviceConversa.findAll().get(0)));
		
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(0), serviceConversa.findAll().get(1)));
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(2), serviceConversa.findAll().get(1)));
		
		serviceDispositivo.save(new Dispositivo("mac", "nome", "token", serviceUsuario.findAll().get(0)));
		serviceDispositivo.save(new Dispositivo("mac2", "nome2", "token", serviceUsuario.findAll().get(0)));

		serviceMensagem.save(new Mensagem("conteudo", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(0)));
		serviceMensagem.save(new Mensagem("conteudo 2", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(2)));
		serviceMensagem.save(new Mensagem("conteudo 3", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(0)));
		serviceMensagem.save(new Mensagem("Olá, Gabriel!", Calendar.getInstance(), serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(1)));
		serviceMensagem.save(new Mensagem("Oi, Allison!", Calendar.getInstance(), serviceUsuario.findAll().get(2),
				serviceConversa.findAll().get(1)));
		
		return "banco populado";
	}
}
