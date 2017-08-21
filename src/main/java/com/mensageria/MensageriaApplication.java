package com.mensageria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MensageriaApplication {

	private static final Logger log = LoggerFactory.getLogger(MensageriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MensageriaApplication.class);
	}

}
