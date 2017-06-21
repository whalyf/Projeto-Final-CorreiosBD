package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Logradouro;

public class LogradouroDao {
	private Connection connection;

	public LogradouroDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Logradouro logradouro) {
		String sql = "insert into logradouros (cep,nome,id_tipo_logradouro, id_cidade) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, logradouro.getCep());
			stmt.setString(2, logradouro.getNome());
			stmt.setLong(3, logradouro.getTipologradouro().getId());
			stmt.setLong(4, logradouro.getBairro().getId());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Logradouro logradouro) {
		String sql = "update logradouros set cep=?, nome=?, id_tipo_logradouro=?, id_bairro=? where id=?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, logradouro.getCep());
			stmt.setString(2, logradouro.getNome());
			stmt.setLong(3, logradouro.getTipologradouro().getId());
			stmt.setLong(4, logradouro.getBairro().getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Logradouro logradouro) {
		try {
			String sql = "delete from estados where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, logradouro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Logradouro> selectnome(String cepOuLogradouro) {

		String sql = "select l.id, l.cep, l.nome, t.nome, b.nome ,c.nome from logradouros l inner join "
				+ "tipos_logradouros t on l.id_tipo_logradouro=t.id inner join "
				+ "bairros b on l.id_bairro=b.id  inner join "
				+ "cidades c on  b.id_cidade=c.id where l.nome like ? or l.cep like ?";
		
		List<Logradouro> logradouros = new ArrayList<Logradouro>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, "%" + cepOuLogradouro + "%");
			stmt.setString(2, "%" + cepOuLogradouro + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Logradouro logradouro = new Logradouro();
				logradouro.setId(rs.getLong("l.id"));
				logradouro.setCep(rs.getString("l.cep"));
				logradouro.setNome(rs.getString("l.nome"));
				logradouro.getTipologradouro().setNome(rs.getString("t.nome"));
				logradouro.getBairro().setNome(rs.getString("b.nome"));
				logradouro.getBairro().getCidade().setNome(rs.getString("c.nome"));
				logradouros.add(logradouro);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return logradouros;

	}

	public List<Logradouro> getLista() {
		try {
			List<Logradouro> logradouros = new ArrayList<Logradouro>();
			PreparedStatement stmt = this.connection.prepareStatement(
					"select l.id, l.cep, l.nome,t.nome, b.nome, c.nome from logradouros l inner join tipos_logradouros "
					+ "t inner join bairros b inner join cidades c "
					+ "on l.id_tipo_logradouro=t.id AND l.id_bairro=b.id AND b.id_cidade=c.id ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Logradouro logradouro = new Logradouro();
				logradouro.setId(rs.getLong("l.id"));
				logradouro.setCep(rs.getString("l.cep"));
				logradouro.setNome(rs.getString("l.nome"));
				logradouro.getTipologradouro().setNome(rs.getString("t.nome"));
				logradouro.getBairro().setNome(rs.getString("b.nome"));
				logradouro.getBairro().getCidade().setNome(rs.getString("c.nome"));
				logradouros.add(logradouro);
			}
			rs.close();
			stmt.close();
			return logradouros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
