package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Logradouro;

import daos.LogradouroDao;

@WebServlet("/listarLogradouros")
public class ServletListarLogradouros extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5633244344815376780L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();

		LogradouroDao dao = new LogradouroDao();

		List<Logradouro> logradouros = dao.getLista();
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<h1>Lista de Logradouros</h1>");

		for (Logradouro logradouro : logradouros) {
			saida.println("ID: " + logradouro.getId());
			saida.println("<br/>");
			saida.println("Nome: " + logradouro.getNome());
			saida.println("<br/>");
			saida.println("<br/>");
		}

		saida.println("<h4>Inserir Pessoa: http://localhost:8080/cep/inserir_pessoa.html</h4>");
		saida.println("</body>");
		saida.println("</html>");
	}
}
