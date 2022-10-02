package br.com.cod3r.exerciciossb2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroAgencia;
	private String nome;
	//novos atributos
	private String endereco;
	private String funcionarios;
		
	//private Banco banco;
	//private Conta conta;
	
	//gerar construtor e getter and setters
	public Agencia() {
		super();	
	}
	
	public Agencia(String nome) {
		super();
		this.nome = nome;
	}
		

	public Agencia(String nome, String endereco, String funcionarios) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.funcionarios = funcionarios;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(String funcionarios) {
		this.funcionarios = funcionarios;
	}

	
	
	
	
}
