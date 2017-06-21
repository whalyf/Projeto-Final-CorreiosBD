package testes;

import java.util.List;

import classes.Pessoa;
import daos.PessoaDao;

public class TestaSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaDao dao = new PessoaDao();
		List<Pessoa> pessoa = dao.getLista();
		
		for (Pessoa pessoas : pessoa) {
			System.out.println("Cpf: " + pessoas.getCpf());
			System.out.println("Nome: " + pessoas.getNome());
			System.out.println("E-Mail: " + pessoas.getEmail());
			System.out.println("Celular: " + pessoas.getCelular());
			System.out.println("Logradouro: " + pessoas.getLogradouro().getId());
			System.out.println("Número: " + pessoas.getNumero());
			System.out.println("Complemento: " + pessoas.getComplemento());

			}
	}

}
