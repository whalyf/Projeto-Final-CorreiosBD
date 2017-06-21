package testes;

import java.util.List;

import classes.Bairro;
import daos.BairroDao;

public class BairroSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BairroDao dao = new BairroDao();
		List<Bairro> bairros = dao.getLista();
		
		for (Bairro bairro: bairros) {
			System.out.println("Nome: " + bairro.getNome());
			System.out.println("Estado: " + bairro.getCidade().getNome());
			}
	}

}


