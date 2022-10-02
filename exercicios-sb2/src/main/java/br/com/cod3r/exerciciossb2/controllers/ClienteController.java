package br.com.cod3r.exerciciossb2.controllers;

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
import br.com.cod3r.exerciciossb2.model.entities.Cliente;
import br.com.cod3r.exerciciossb2.model.entities.Produto;
import br.com.cod3r.exerciciossb2.model.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	/*
	 * @GetMapping("/qualquer") public Cliente obteCliente() { return new
	 * Cliente(28, "Pedro","259.234.345-79"); } //variavel que modifica {id}
	 * 
	 * @GetMapping("/{id}") public Cliente obteClientePorId1(@PathVariable int id) {
	 * return new Cliente(id,"Maria","339.234.345-79"); }
	 * 
	 * 
	 * //Situação corretav = Sem a utilização do Id é o correto para não ficar
	 * gravado o id na URL
	 * 
	 * @GetMapping public Cliente obteClientePorId2(@RequestParam(name = "id",
	 * defaultValue = "1") int id) { return new
	 * Cliente(id,"João Correto","119.234.345-79"); }
	 */

	@GetMapping
	public String buscar() {
		return "buscando Clientes";
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable Integer id) {
		return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	private ClienteRepository clienteRepository;
	// Recebendo @RequestParam do Header da URL

	// erro : xerciciossb2.model.repositories.ClienteRepository.save(Object)\"
	// because \"this.clienteRepository\" is null",
	@PostMapping
	public @ResponseBody Cliente novoCliente(@RequestParam String nome) {
		Cliente cliente = new Cliente(nome);
		clienteRepository.save(cliente);
		return cliente;
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return clienteRepository.findById(id).map(record -> {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		return clienteRepository.findById(id).map(record -> {
			record.setNome(cliente.getNome());
			Cliente updated = clienteRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
}
