package testes;

import java.sql.Connection;
import java.sql.SQLException;

import daos.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();

	}

}
