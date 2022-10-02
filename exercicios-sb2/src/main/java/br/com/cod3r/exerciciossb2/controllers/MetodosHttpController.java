package br.com.cod3r.exerciciossb2.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos") 
public class MetodosHttpController {
	
	@GetMapping("/get")
	public String get() {
		return "Requisição GET";
	}
	@PostMapping("/post")
	public String post() {
		return "Requisição post";
	}
	@PutMapping("/put")
	public String put() {
		return "Requisição put";
	}
	@PatchMapping("/patch")
	public String patch() {
		return "Requisição patch";
	}
	@DeleteMapping("/delete")
	public String delete() {
		return "Requisição delete";
	}

}
