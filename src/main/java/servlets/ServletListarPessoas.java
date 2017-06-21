package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Pessoa;
import daos.PessoaDao;

@WebServlet("/listarPessoas")

public class ServletListarPessoas extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2537869885127880464L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter saida = response.getWriter();

		PessoaDao dao = new PessoaDao();
		
		List<Pessoa> pessoas = dao.getLista();

		
		
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<head>");
		saida.println("<title>Consulta</title>");
		saida.println("<link rel='stylesheet' href='resources/css/bootstrap.min.css'>");
		saida.println("<link rel='stylesheet'href=resources/css/style.css'>");
		saida.println("</head>");
		
		saida.println("<h1>Quem deseja Atualizar ou Deletar ?</h1>");
		saida.println("-----"+"<a href="+"http://localhost:8080/cep/remover_pessoa.html"+">Remover Pessoa</a>");
		saida.println("-----"+"<a href="+"http://localhost:8080/cep/atualizar_pessoa.html"+">Atualizar Pessoa</a>");
		saida.println("     ");
		saida.println("-----"+"<a href="+"http://localhost:8080/cep/inserir_pessoa.html"+">Inserir Pessoa</a>"+"-----");
	
		saida.println("<div class='container' style='padding: 20px'>");
		saida.println("<table class='table'>"
				+ "<thead style='background-color: #ddd'><tr><th scope='col'>ID</th><th scope='col'>Nome</th>"
				+ "<th scope='col'>CPF</th><th scope='col'>Celular</th><th scope='col'>Logradouro</th></tr>"
				+ "<th scope='col'>Número</th><th scope='col'>Complemento</th></thead>");
		
		saida.println("<tbody>");
		
		for (Pessoa pessoa : pessoas) {
			saida.println("<tr> " + "<td>" + pessoa.getId() + " " + "</td>" + "<td>" + pessoa.getNome() + " " + "</td>"
					+ "<td>" + pessoa.getCpf() + " " + "</td>" + "<td>" + pessoa.getCelular()
					+ " " + "</td>" + "<td>" + pessoa.getLogradouro().getNome() + " " + "</td>" + "<td>" + pessoa.getNumero() + " " + "</td>"+
					"<td>" + pessoa.getComplemento() + " " + "</td>"+"</tr>");
			
			/*saida.println("ID: " + pessoa.getId());
			saida.println("<br/>");
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
			saida.println("<br/>");*/
		}
		saida.println("</table>");
		saida.println("</div>");
		saida.println("</body>");
		saida.println("</html>");
		
	}
}
