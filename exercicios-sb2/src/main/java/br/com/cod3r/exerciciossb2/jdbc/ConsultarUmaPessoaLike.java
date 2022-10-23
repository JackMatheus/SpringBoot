package br.com.cod3r.exerciciossb2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarUmaPessoaLike {

	public static void main(String[] args) throws SQLException {
		// 1-Informando o dado da pesquisa
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite a sua busca aqui: ");
		String pesquisa = entrada.nextLine();

		// 2- Pesquisa do dado no DB
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas where nome like ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + pesquisa + "%");
		ResultSet resultado = stmt.executeQuery();

		// 3-Instanciando uma lista de pessoas
		List<Pessoa> pessoas = new ArrayList<>();
		// 3.1-Com Base nos resultado
		while (resultado.next()) {
			// Variaveis que vão receber info da tabela(codigo e nome) do banco de dados
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));

		}
		;
		// 4-Exibindo os dados da pesquisa
		for (Pessoa p : pessoas) {
			System.out.println("=>" + p.getCodigo() + "==>" + p.getNome());
		}
		conexao.close();
		entrada.close();
	}
}
