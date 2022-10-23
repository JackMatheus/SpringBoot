package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe seu nome: ");
		String nome = entrada.nextLine();
		
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "insert into pessoas (nome)values(?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		//metodo setString tem2 parametros
		stmt.setString(1, nome);
		stmt.execute();
		System.out.println("Pessoa Incluida pelo Java no DB com sucesso");
		
		entrada.close();
		
	}
}
