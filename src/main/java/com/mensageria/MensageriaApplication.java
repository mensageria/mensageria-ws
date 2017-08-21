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
import com.mensageria.repositorios.ConfirmacaoRepository;
import com.mensageria.repositorios.ConversaRepository;
import com.mensageria.repositorios.DispositivoRepository;
import com.mensageria.repositorios.UsuarioRepository;
import com.mensageria.services.MensagemService;

@SpringBootApplication
public class MensageriaApplication {

	private static final Logger log = LoggerFactory.getLogger(MensageriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

}
