package br.com.cod3r.exerciciossb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cod3r.exerciciossb2.model.entities.Agencia;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ExerciciosSb2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExerciciosSb2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Agencia agencia = new Agencia("Mobumbi","rua Benvenuto","Maria");
		
	}
}
