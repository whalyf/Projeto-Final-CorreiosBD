package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Pessoa;
import daos.PessoaDao;

@WebServlet("/atualizarPessoa")
public class ServletAtualizarPessoa extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2403474111290946885L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();
		String id = request.getParameter("id");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");

		Pessoa pessoa = new Pessoa();

		pessoa.setId(Long.parseLong(id));
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCelular(celular);
		pessoa.getLogradouro().setId(Long.parseLong(logradouro));
		pessoa.setNumero(numero);
		pessoa.setComplemento(complemento);

		PessoaDao dao = new PessoaDao();
		dao.altera(pessoa);

		saida.println("<html>");
		saida.println("<body>");
		saida.println("<h3>Alteração Realizada com Sucesso:</h3>");
		saida.println("<h4>Novos Dados:</h4>");
		saida.println("Nome: " + pessoa.getNome());
		saida.println("<br/>");
		saida.println("Cpf: " + pessoa.getCpf());
		saida.println("<br/>");
		saida.println("Celular: " + pessoa.getCelular());
		saida.println("<br/>");
		saida.println("Logradouro: " + pessoa.getLogradouro().getNome());
		saida.println("<br/>");
		saida.println("Numero: " + pessoa.getNumero());
		saida.println("<br/>");
		saida.println("Complemento: " + pessoa.getComplemento());
		saida.println("<br/>");
		saida.println("<br/>");
		saida.println("<a href="+"http://localhost:8080/cep/listar_pessoas.html"+">Listar Pessoas</a>");
		saida.println("</body>");
		saida.println("</html>");
	}

}
