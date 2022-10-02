package br.com.cod3r.exerciciossb2.model.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	//Continuar a partir daqui -> persistir agencia dentro do Banco
	//@OneToMany
	//private Agencia agencia;
	//Recebendo Obj Item	
	ArrayList<Agencia> agencia = new ArrayList<Agencia>();
	
	
	public Banco() {
		super();	
	}
	
	public Banco (String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
