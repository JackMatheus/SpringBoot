package br.com.cod3r.exerciciossb2.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb2.model.entities.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
