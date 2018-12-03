package br.edu.utfpr.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.Role;
import br.edu.utfpr.model.Usuario;

@WebServlet("/a/lista")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ADDRESS = "/WEB-INF/view/lista.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) Usuario.all();
		HttpSession session = request.getSession();
		session.setAttribute("listaUsuarios", listaUsuarios);
		
		ArrayList<Role> listaRoles = (ArrayList<Role>) Role.all();
		session.setAttribute("listaRoles", listaRoles);
		
		request.getRequestDispatcher(ADDRESS).forward(request, response);
		
	}

}
