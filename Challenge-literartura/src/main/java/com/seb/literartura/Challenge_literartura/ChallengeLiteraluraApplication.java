package com.seb.literartura.Challenge_literartura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@ComponentScan(basePackages = "com.seb.literartura.Challenge_literartura")
@EnableJpaRepositories(basePackages = "com.seb.literartura.Challenge_literartura.repository")
public class ChallengeLiteraluraApplication implements CommandLineRunner {

	@Autowired
	private AppConsole app;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			app.ejecutarOperaciones(); // Ejecuta las operaciones en AppConsole
		} catch (Exception e) {
			System.err.println("Error en la ejecución: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
