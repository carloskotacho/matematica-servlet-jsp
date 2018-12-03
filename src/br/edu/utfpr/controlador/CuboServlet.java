package br.edu.utfpr.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.builder.CuboBuilder;
import br.edu.utfpr.util.Util;

@WebServlet("/u/cubo")
public class CuboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String ADDRESS = "resultado";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = "/WEB-INF/view/forms/cubo-form.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Util util = new Util();
		
		double lado = 0.0;
		
		try {
			lado = Double.parseDouble(request.getParameter("lado"));
		}catch (Exception e) {
			throw new NumberFormatException("Erro na conversão númerica");
		}
		
		util.construirSolido(new CuboBuilder(lado), session);
		util.parameterMap(request, session);
		
		response.sendRedirect(ADDRESS);
	}
}
