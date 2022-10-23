package br.com.cod3r.exerciciossb2.jdbc;

public class DAOTeste {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";
		
		System.out.println(dao.incluir(sql, "João da Silva", 24 ));
		System.out.println(dao.incluir(sql, "Ana Julia", 32));
		System.out.println(dao.incluir(sql, "Djalma Pereira", 18));
		
		dao.close();
	}

}
