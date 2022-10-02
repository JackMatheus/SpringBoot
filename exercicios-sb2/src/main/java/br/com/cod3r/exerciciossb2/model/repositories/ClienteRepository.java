package br.com.cod3r.exerciciossb2.model.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.cod3r.exerciciossb2.model.entities.Cliente;
//<Classe, tipo Id> => <Produto, Integer>

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
