package testes;

import classes.Estado;
import daos.EstadoDao;

public class TestaUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estado estados = new Estado();
		estados.setUf("WV");
		estados.setNome("Whal");
		estados.setId(32L);
		
		EstadoDao bd = new EstadoDao();
		
		bd.altera(estados);
		
		System.out.println("Alterado!");
	}

}
