package com.bizao.gestionvol;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class GestionVolApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionVolApplication.class, args);
	}

}
