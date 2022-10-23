package br.com.cod3r.exerciciossb2.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "agencia_id")
	private int numeroAgencia;
	private String nome;
	//novos atributos
	private String endereco;
	private String funcionarios;
		
	@ManyToOne
	private Banco banco;
	
	@OneToMany
	private List<Cliente>cliente;
	//private Conta conta;
	
	//gerar construtor e getter and setters

	public Agencia() {
		super();
		// TODO Auto-generated constructor stub
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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	
	
	
	
	
	
	
}
