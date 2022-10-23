package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {

		// 1-Informando o dado da pesquisa
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o código: ");
		int pesquisaCodigo = entrada.nextInt();

		// 2- Pesquisa do dado no DB
		Connection conexao = FabricaConexao.getConexao();
		String sqlDelete = "DELETE FROM pessoas where codigo=?";
		//String sqlDelete = "DELETE FROM pessoas where codigo>?";
		PreparedStatement stmt = conexao.prepareStatement(sqlDelete);
		stmt.setInt(1, pesquisaCodigo);
		
		int contador = stmt.executeUpdate();
		
		if (contador > 0) {
			System.out.println("Pessoa excluida com sucesso!!!");
			

		} else {
			System.out.println("Pessoa não encontrada");
		}
		;
		System.out.println("Linhas afetadas " + contador); 
		conexao.close();
		entrada.close();

	}

}
