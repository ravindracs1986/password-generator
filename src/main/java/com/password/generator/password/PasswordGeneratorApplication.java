package com.password.generator.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PasswordGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordGeneratorApplication.class, args);
	}

}
