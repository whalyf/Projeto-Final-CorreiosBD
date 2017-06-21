package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daos.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
	
		String sql = "INSERT INTO estados" + " (uf,nome)" + " values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, "Ti");
		stmt.setString(2, "tech");	

		stmt.execute();
		stmt.close();
		System.out.println("Gravado!");
		con.close();

	}

}
