package com.mensageria;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mensageria.model.Conversa;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Usuario;
import com.mensageria.model.repositorios.MensagensRepository;

@SpringBootApplication
public class MensageriaApplication {

	private static final Logger log = LoggerFactory.getLogger(MensageriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(MensagensRepository repository) {
		return (args) -> {
			// save a couple of Mensagems
			Usuario usuario = new Usuario("email", true, "nome", Calendar.getInstance());
			Conversa conversa = new Conversa(true, "conversa", Calendar.getInstance());
			
			repository.save(new Mensagem("conteudo", Calendar.getInstance(), usuario, conversa));
			
			// fetch all Mensagems
			log.info("Mensagems found with findAll():");
			log.info("-------------------------------");
			for (Mensagem Mensagem : repository.findAll()) {
				log.info(Mensagem.toString());
			}
			log.info("");

			// fetch an individual Mensagem by ID
			Mensagem Mensagem = repository.findOne(1L);
			log.info("Mensagem found with findOne(1L):");
			log.info("--------------------------------");
			log.info(Mensagem.toString());
			log.info("");

		};
	}

}
