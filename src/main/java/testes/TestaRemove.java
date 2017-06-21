package testes;

import classes.Estado;
import daos.EstadoDao;

public class TestaRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estado estados = new Estado();
		estados.setId(32L);
		
		EstadoDao bd = new EstadoDao();
		
		bd.remove(estados);
		
		System.out.println("Removido!");
	}

}
