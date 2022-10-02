package br.com.cod3r.exerciciossb2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numIdentify;
	private String nome;
	private String conta;
	private String cpf;

	public Cliente() {
		super();
	}

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public Cliente(int numIdentify) {
		super();
		this.numIdentify = numIdentify;
	}

	public Cliente(String conta, String cpf) {
		super();
		this.conta = conta;
		this.cpf = cpf;
	}
	

	public int getNumIdentify() {
		return numIdentify;
	}

	public void setNumIdentify(int numIdentify) {
		this.numIdentify = numIdentify;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
