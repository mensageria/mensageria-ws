package com.mensageria;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mensageria.model.Conversa;
import com.mensageria.model.Dispositivo;
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

		Calendar data = Calendar.getInstance();
		serviceUsuario.save(new Usuario("allison@g.com", true, "Allison Verdam", data,0));
		serviceUsuario.save(new Usuario("renan@g.com", true, "Renan Barros", data,0));
		serviceUsuario.save(new Usuario("gabriel@g.com", true, "Gabriel Lima", data,0));
		serviceUsuario.save(new Usuario("luiz@g.com", true, "Luiz Fernando", data,1));

		serviceConversa.save(new Conversa(true, "conversa 1", data));
		serviceConversa.save(new Conversa(true, "conversa 2", data));
		serviceConversa.save(new Conversa(false, "conversa 3", data));
		
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(0), serviceConversa.findAll().get(0)));
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(1), serviceConversa.findAll().get(0)));
		
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(0), serviceConversa.findAll().get(1)));
		serviceParticipa.save(new Participa(serviceUsuario.findAll().get(2), serviceConversa.findAll().get(1)));
		
		serviceDispositivo.save(new Dispositivo("nome", "token",data, serviceUsuario.findAll().get(0)));
		serviceDispositivo.save(new Dispositivo("nome2", "token",data, serviceUsuario.findAll().get(0)));

		serviceMensagem.save(new Mensagem("conteudo", data, serviceUsuario.findAll().get(3),
				serviceConversa.findAll().get(0)));
		serviceMensagem.save(new Mensagem("conteudo 2", data, serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(2)));
		serviceMensagem.save(new Mensagem("conteudo 3", data, serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(0)));
		serviceMensagem.save(new Mensagem("Olá, Gabriel!", data, serviceUsuario.findAll().get(0),
				serviceConversa.findAll().get(1)));
		serviceMensagem.save(new Mensagem("Oi, Allison!", data, serviceUsuario.findAll().get(2),
				serviceConversa.findAll().get(1)));
		
		return "banco populado";
	}
}
