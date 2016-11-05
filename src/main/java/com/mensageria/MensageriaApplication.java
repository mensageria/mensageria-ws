package com.mensageria;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mensageria.model.Confirmacao;
import com.mensageria.model.Conversa;
import com.mensageria.model.Dispositivo;
import com.mensageria.model.Instituicao;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;
import com.mensageria.model.repositorios.ConfirmacaoRepository;
import com.mensageria.model.repositorios.ConversaRepository;
import com.mensageria.model.repositorios.DispositivoRepository;
import com.mensageria.model.repositorios.MensagensRepository;
import com.mensageria.model.repositorios.UsuarioRepository;

@SpringBootApplication
public class MensageriaApplication {

	private static final Logger log = LoggerFactory.getLogger(MensageriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

	// TODO remover testes
	@Bean
	public CommandLineRunner demo(MensagensRepository repositoryMensagem, UsuarioRepository repositoryUsuario,
			ConversaRepository repositoryConversa, DispositivoRepository repositoryDispositivo,
			ConfirmacaoRepository repositoryConfirmacao) {
		return (args) -> {
			repositoryUsuario.save(new Usuario("email", true, "nome", Calendar.getInstance()));
			repositoryUsuario.save(new Instituicao("email 2", true, "nome 2", Calendar.getInstance(), "cnpj"));

			repositoryConversa.save(new Conversa(true, "conversa", Calendar.getInstance()));
			repositoryConversa.save(new Conversa(false, "conversa 2", Calendar.getInstance()));

			repositoryDispositivo.save(new Dispositivo("mac", "nome", "token", repositoryUsuario.findOne(1L)));
			repositoryDispositivo.save(new Dispositivo("mac2", "nome2", "token", repositoryUsuario.findOne(1L)));

			repositoryMensagem.save(
					new Mensagem("conteudo", Calendar.getInstance(), repositoryUsuario.findOne(1L), repositoryConversa.findOne(1L)));
			repositoryMensagem.save(new Mensagem("conteudo 2", Calendar.getInstance(), repositoryUsuario.findOne(1L),
					repositoryConversa.findOne(2L)));
			repositoryMensagem.save(new Mensagem("conteudo 3", Calendar.getInstance(), repositoryUsuario.findOne(2L),
					repositoryConversa.findOne(1L)));

			repositoryConfirmacao.save(new Confirmacao(false, false, repositoryUsuario.findOne(1L),
					repositoryConversa.findOne(2L)));
			
			log.info("Mensagems found with findAll():");
			log.info("-------------------------------");
			for (Mensagem mensagem : repositoryMensagem.findAll()) {
				log.info(mensagem.toString());
			}
			log.info("");

			log.info("Usuarios found with findAll():");
			log.info("-------------------------------");
			for (Usuario usuario : repositoryUsuario.findAll()) {
				log.info(usuario.toString());
			}
			log.info("");

			log.info("Conversas found with findAll():");
			log.info("-------------------------------");
			for (Conversa conversa : repositoryConversa.findAll()) {
				log.info(conversa.toString());
			}
			log.info("");

			log.info("Dispositivo found with findAll():");
			log.info("-------------------------------");
			for (Dispositivo dispositivo : repositoryDispositivo.findAll()) {
				log.info(dispositivo.toString());
			}
			log.info("");
			
			log.info("Confirmacao found with findAll():");
			log.info("-------------------------------");
			for (Confirmacao confirmacao : repositoryConfirmacao.findAll()) {
				log.info(confirmacao.toString());
			}
			log.info("");
			
			log.info("Mensagens found with findByAutor(Usuario autor):");
			log.info("-------------------------------");
			for (Mensagem mensagem : repositoryMensagem.findByAutor(repositoryUsuario.findOne(2L))) {
				log.info(mensagem.toString());
			}
			log.info("");

		};
	}

}
