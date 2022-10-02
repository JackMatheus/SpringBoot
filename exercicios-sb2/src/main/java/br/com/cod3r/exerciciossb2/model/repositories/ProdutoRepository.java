package br.com.cod3r.exerciciossb2.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.cod3r.exerciciossb2.model.entities.Produto;

//<Classe, tipo Id> => <Produto, Integer>
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {
	// findByNome = atributo da classe(nome)
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	// Jpql aqui se necessário
	
	//// findByNomeContaining
	//// findByNomeIsContaining
	// findByNomeContains

	// findByNomeStartWith
	// findByNomeEndsWith

	// findByNomeNotContaining

	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);

}
