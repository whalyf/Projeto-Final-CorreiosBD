package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Logradouro;
import daos.LogradouroDao;

@WebServlet("/buscarLogradouroNome")
public class ServletBuscarLogradouroNome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2368783549311194767L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		LogradouroDao dao = new LogradouroDao();
		List<Logradouro> logradouros = new ArrayList<>();
		logradouros = dao.getLista();

		String nome = request.getParameter("nome");

		try {
			logradouros = dao.selectnome(nome);

		} catch (Exception e) {

			e.printStackTrace();
		}

		/*	for (Logradouro logr : logradouros) {
		saida.println("<body>");
		saida.println("<html>");
		saida.println("Nome: " + logr.getNome());
		saida.println("<br/>");
		saida.println("CEP: " + logr.getCep());
		saida.println("<br/>");
		saida.println("Tipo de Logradouro: " + logr.getTipologradouro().getNome());
		saida.println("<br/>");
		saida.println("Bairro: " + logr.getBairro().getNome());
		saida.println("<br/>");
		saida.println("Cidade:" + logr.getBairro().getCidade().getNome());
		saida.println("<br/>");
		saida.println("<br/>");
		saida.println("</body>");
		saida.println("</html>");

	}
}
}*/
		out.println("<a href="+"http://localhost:8080/cep/buscar_logradouro_nome.html"+">Buscar Logradouro/CEP</a>");
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Consulta</title>");
		out.println("<link rel='stylesheet' href='resources/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet'href=resources/css/style.css'>");
		out.println("</head>");
		out.println("<div class='container' style='padding: 20px'>");
		out.println("<table class='table'>"
				+ "<thead style='background-color: #ddd'><tr><th scope='col'>ID</th><th scope='col'>Cep</th><th scope='col'>Nome</th>"
				+ "<th scope='col'>Logradouro</th><th scope='col'>Bairro</th><th scope='col'>Cidade</th></tr></thead>");
		out.println("<tbody>");
		
		for (Logradouro logr : logradouros) {
			
			out.println("<tr> " + "<td>" + logr.getId() + "<td>" + logr.getCep()+ " " + "</td>" + "<td>" + logr.getNome() + " " + "</td>"
					+ "<td>" + logr.getTipologradouro().getNome() + " " + "</td>" + "<td>" + logr.getBairro().getNome()
					+ " " + "</td>" + "<td>" + logr.getBairro().getCidade().getNome() + " " + "</td>" + "</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
