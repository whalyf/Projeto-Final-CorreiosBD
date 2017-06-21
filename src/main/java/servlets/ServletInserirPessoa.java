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

@WebServlet("/inserirPessoa")

public class ServletInserirPessoa extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136127752698247638L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();

		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setCelular(celular);
		pessoa.getLogradouro().setId(Long.parseLong(logradouro));
		pessoa.setNumero(numero);
		pessoa.setComplemento(complemento);

		PessoaDao dao = new PessoaDao();
		dao.adiciona(pessoa);

		saida.println("<html>");
		saida.println("<body>");
		saida.println(pessoa.getNome() + "<h2> Adicionada(o) com sucesso</h2>");
		saida.println("<br/>");
		saida.println("<br/>");
		saida.println("<a href="+"http://localhost:8080/cep/listar_pessoas.html"+">Listar Pessoas</a>");
		saida.println("<br/>");
		saida.println("</body>");
		saida.println("</html>");
	}
}
