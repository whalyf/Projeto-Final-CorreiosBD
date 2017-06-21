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

@WebServlet("/removerPessoa")

public class ServletRemoverPessoa extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3667003495814156377L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();
		String nome = request.getParameter("nome");
				
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		
		PessoaDao dao = new PessoaDao();
		dao.remove(pessoa);
		
		saida.println("<html>");
		saida.println("<body>");
		saida.println(pessoa.getNome() + " Foi Removido(a)");
		saida.println("</body>");
		saida.println("</html>");
		
	}
}







