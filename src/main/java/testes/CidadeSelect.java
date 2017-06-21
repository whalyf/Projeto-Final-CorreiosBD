package testes;

import java.util.List;

import classes.Cidade;
import daos.CidadeDao;


public class CidadeSelect {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CidadeDao dao = new CidadeDao();
		List<Cidade> cidades = dao.getLista();
		
		for (Cidade cidade: cidades) {
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			}
	}

}


