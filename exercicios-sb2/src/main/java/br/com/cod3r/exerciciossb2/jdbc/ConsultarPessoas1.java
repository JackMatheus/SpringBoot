package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

	public static void main(String[] args) throws SQLException {

		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";

		Statement stmt = conexao.createStatement();
		// Intanciando o resultado
		ResultSet resultado = stmt.executeQuery(sql);
		// Instanciando uma lista de pessoas
		List<Pessoa> pessoas = new ArrayList<>();

		while (resultado.next()) {
			// Variaveis que vão receber info do banco de dados
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));

		}

		for (Pessoa p : pessoas) {
			System.out.println("=>" + p.getCodigo() + "==>" + p.getNome());
		}
		conexao.close();

	}

}
