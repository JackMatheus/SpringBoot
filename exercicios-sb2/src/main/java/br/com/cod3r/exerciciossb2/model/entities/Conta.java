package br.com.cod3r.exerciciossb2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroConta;
	private String tipoConta;	
	private double saldo;
	
	//private Agencia agencia;
	//private Cliente cliente;
	
	//Aqui ok
	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Conta(String tipoConta) {
		super();	
		this.tipoConta = tipoConta;
		}


	public Conta(int numeroConta, String tipoConta, double saldo) {
		super();
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
	
	

}
