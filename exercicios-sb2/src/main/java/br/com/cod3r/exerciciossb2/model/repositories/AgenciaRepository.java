package br.com.cod3r.exerciciossb2.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb2.model.entities.Agencia;

//<Classe, tipo Id> => <Agencia, Integer>
public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{

}
