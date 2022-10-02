package br.com.cod3r.exerciciossb2.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb2.model.entities.Banco;

//Diferente
public interface BancoRepository extends CrudRepository<Banco, Integer> {

}

