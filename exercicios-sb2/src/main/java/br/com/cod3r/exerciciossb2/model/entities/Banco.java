package br.com.cod3r.exerciciossb2.model.entities;

import java.util.ArrayList;
import java.util.List;

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

	// Continuar a partir daqui -> persistir agencia dentro do Banco
	@OneToMany(mappedBy="numeroAgencia")	
	private List<Agencia> agencia = new ArrayList<Agencia>();

	public Banco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Banco(String nome) {
		super();
		this.nome = nome;

	}

	public Banco(String nome, List<Agencia> agencia) {
		super();
		this.nome = nome;
		this.agencia = agencia;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Agencia> getAgencia() {
		return agencia;
	}

	public void setAgencia(List<Agencia> agencia) {
		this.agencia = agencia;
	}
	
	

}
