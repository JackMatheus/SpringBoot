package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	public static Connection getConexao() {
		
		try {
			final String url = "jdbc:mysql://localhost/curso_javaSTMT?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String senha = "";
			return DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			//System.out.println("Conexão não encontrada");
			throw new RuntimeException(e);
		}
	}

}
