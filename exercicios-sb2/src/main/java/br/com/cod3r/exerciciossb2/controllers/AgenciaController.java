package br.com.cod3r.exerciciossb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb2.model.entities.Agencia;
import br.com.cod3r.exerciciossb2.model.entities.Produto;
import br.com.cod3r.exerciciossb2.model.repositories.AgenciaRepository;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaController {
	
	@GetMapping("/qualquer")
	public Agencia obteAgencia() {
		//return new Agencia("Agencia teste"); 
		return null;
	}
	
	@Autowired
	private AgenciaRepository agenciaRepository ;
	//Recebendo @RequestParam do Header da URL
	@PostMapping
	public @ResponseBody Agencia novaAgencia(@RequestParam String nome) {
		Agencia agencia = new Agencia();
		agenciaRepository.save(agencia);
		return agencia;
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable Integer id){
	   return agenciaRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id,
	                                      @RequestBody Produto produto) {
	   return agenciaRepository.findById(id)
	           .map(record -> {
	               record.setNome(produto.getNome());
	               Agencia updated = agenciaRepository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Integer id) {
	   return agenciaRepository.findById(id)
	           .map(record -> {
	        	   agenciaRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	

}
