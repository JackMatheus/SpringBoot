package br.com.cod3r.exerciciossb2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	//@RequestMapping(method = RequestMethod.GET, path= "/ola")
	@GetMapping(path = { "/ola", "/saudacao"})
	public String olagafanhoto() {		
		return "Olá pequeno gafanhoto, usando Sprint Boot !!!!";
	}
	


}
