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

import br.com.cod3r.exerciciossb2.model.entities.Conta;
import br.com.cod3r.exerciciossb2.model.entities.Produto;
import br.com.cod3r.exerciciossb2.model.repositories.ContaRepository;


@RestController
@RequestMapping("/api/contas")
public class ContaController {

	@GetMapping
	public String buscar() {
		return "buscando Conta";
	}
	
	
	@Autowired
	private ContaRepository contaRepository;
	//Recebendo @RequestParam do Header da URL
	@PostMapping
	public @ResponseBody Conta novaConta (@RequestParam String tipoConta) {
		Conta conta = new Conta(tipoConta);
		contaRepository.save(conta);
		return conta;
		
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable Integer id){
	   return contaRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Integer id) {
	   return contaRepository.findById(id)
	           .map(record -> {
	        	   contaRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id,
	                                      @RequestBody Conta conta) {
	   return contaRepository.findById(id)
	           .map(record -> {
	               record.setTipoConta(conta.getTipoConta());
	               Conta updated = contaRepository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}

}
