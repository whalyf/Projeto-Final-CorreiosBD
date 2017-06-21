package testes;

import classes.Estado;
import daos.EstadoDao;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estado estados = new Estado();
		estados.setUf("CA");
		estados.setNome("Caelum");
		
		EstadoDao bd = new EstadoDao();
		
		bd.adiciona(estados);
		
		System.out.println("Gravado!");

	}
}
