package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Role;
import br.edu.utfpr.model.Usuario;

@WebServlet("/a/deletar")
public class DeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ADDRESS = "home";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = "/WEB-INF/view/admin/form-deletar.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginUsuario = request.getParameter("login");
		
		Usuario usuario = Usuario.findByLogin(loginUsuario);
		Role role = Role.findByLogin(loginUsuario);
		
		usuario.delete();
		role.delete();
		
		response.sendRedirect(ADDRESS);
		
	}

}
