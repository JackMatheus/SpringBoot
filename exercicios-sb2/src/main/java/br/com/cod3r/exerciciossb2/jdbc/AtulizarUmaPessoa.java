package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtulizarUmaPessoa {

	public static void main(String[] args) throws SQLException {
		// 1-Informando o dado da pesquisa
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o código: ");
		int pesquisaCodigo = entrada.nextInt();

		// 2- Pesquisa do dado no DB
		Connection conexao = FabricaConexao.getConexao();
		String sqlSelect = "SELECT codigo, nome FROM pessoas where codigo=?";
		PreparedStatement stmt = conexao.prepareStatement(sqlSelect);
		stmt.setInt(1, pesquisaCodigo);
		ResultSet resultado = stmt.executeQuery();

		// 3.1-Com Base nos resultado
		if (resultado.next()) {
			// Variaveis que vão receber info da tabela(codigo e nome) do banco de dados
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getNString(2));

			System.out.println("O nome da pessoa é: " + p.getNome());
			entrada.nextLine();

			System.out.println("Atualize o nome: ");
			String novoNome = entrada.nextLine();

			stmt.close();
			String sqlUpdate = "UPDATE pessoas set nome=? where codigo=?";
			// new Statement
			stmt = conexao.prepareStatement(sqlUpdate);
			stmt.setString(1, novoNome);
			stmt.setInt(2, pesquisaCodigo);
			stmt.execute();
			
			//Pessoa p = new Pessoa();
			
			System.out.println("Pessoa alterada com sucesso, seu novo nome é: " + novoNome);

		}else {
			System.out.println("Pessoa não encontrada");
		}
		;

		conexao.close();
		entrada.close();

	}

}
