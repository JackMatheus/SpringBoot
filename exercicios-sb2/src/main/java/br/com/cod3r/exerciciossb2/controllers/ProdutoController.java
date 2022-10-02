package br.com.cod3r.exerciciossb2.controllers;

import java.awt.print.Pageable;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb2.model.entities.Produto;
import br.com.cod3r.exerciciossb2.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	// @GetMapping
	public String buscar() {
		return "buscando Produto";
	}

	@Autowired
	private ProdutoRepository produtoRepository;

	// Recebendo @RequestParam do Header da URL
	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	// add by GetMapping(path = { "/optional/{id}" })
	@GetMapping
	public Iterable<Produto> obterProduto() {
		return produtoRepository.findAll();
	}
	
	@GetMapping (path = { "/optional/nome/{parteNome}" })
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome) {
		//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
		return produtoRepository.searchByNameLike(parteNome);
	}
	@GetMapping(path = { "/optional/{id}" })
	public Optional<Produto> obterProdutoPorId(@PathVariable Integer id) {
		return produtoRepository.findById(id);
	}
	//Implementando paginador com o PagingAndSortingRepository
	@GetMapping(path = { "/optional/pagina/{numeroPagina}/{qtdePagina}" })
	public Iterable<Produto> obterProdutoPorPagina(
			@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if(qtdePagina>=10) qtdePagina =10;
			org.springframework.data.domain.Pageable page = PageRequest.of(numeroPagina, qtdePagina);
			return produtoRepository.findAll(page);
	}

	@PutMapping(path = { "/optional/{id}" })
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@PostMapping(path = { "/optional/{id}" })
	public Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@DeleteMapping(path = { "/optional/{id}" })
	public void deletarProduto(@PathVariable Integer id) {
		produtoRepository.deleteById(id);
	    	
	}

	//

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable Integer id) {
		return produtoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return produtoRepository.findById(id).map(record -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Produto produto) {
		return produtoRepository.findById(id).map(record -> {
			record.setNome(produto.getNome());
			Produto updated = produtoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

}
