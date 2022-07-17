package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
    JavaBeans contato = new JavaBeans();
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contato(request, response);
		}else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar contatos
	protected void contato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContato();
		
	}
	
	// Novo contatos
		protected void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
	// Setar as variaveis JavaBeans
		contato.setnome(request.getParameter("nome"));
		contato.setemail(request.getParameter("nome"));
		contato.setinformacao(request.getParameter("nome"));
		// invocaro metodo inserirContato passando o objeto contato
		dao.inserirContato(contato);
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
  }
}
