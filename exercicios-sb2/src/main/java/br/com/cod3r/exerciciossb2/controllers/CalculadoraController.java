package br.com.cod3r.exerciciossb2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	// URL -> http://localhost:8081/calculadora/somar/10/20
	// Desafio-> /calculadora/somar/10/20
	@GetMapping("/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	// URL -> http://localhost:8081/calculadora/subtrair?a=100&b=30
	// Desafio-> /calculadora/subtratir?a=100&b=30
	@GetMapping("/subtrair")
	public int subtrair(
			@RequestParam(name = "a") int a, 
			@RequestParam(name = "b") int b) {
		return a - b;
	}

}
