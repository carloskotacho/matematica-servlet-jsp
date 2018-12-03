package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.Role;
import br.edu.utfpr.model.Usuario;
import br.edu.utfpr.util.Sha256Generator;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String USUARIO = "USUARIO";
	private static final String ADDRESS = "login";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = "/form-cadastro.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Boolean isAdministrador = (Boolean) session.getAttribute("isAdministrador");

		String tipoRole;
		if(isAdministrador != null) {
			tipoRole = isAdministrador ? request.getParameter("tRole") : USUARIO;
		}else {
			tipoRole = USUARIO;
		}
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		Sha256Generator generator = new Sha256Generator();
		pwd = generator.generate( pwd );
		
		Usuario usuario = new Usuario(login, pwd);
		usuario.save();
		Role role = new Role(login, tipoRole);
		role.save();
		
		request.getRequestDispatcher(ADDRESS).forward(request, response);
		
	}

}
