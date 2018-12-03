package br.edu.utfpr.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.builder.ConeBuilder;
import br.edu.utfpr.util.Util;

@WebServlet("/u/cone")
public class ConeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ADDRESS = "resultado";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = "/WEB-INF/view/forms/cone-form.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();		
		double raio = 0.0, altura = 0.0, geratriz = 0.0;
		
		Util util = new Util();
		
		try {
			raio = Double.parseDouble(request.getParameter("raio"));
			altura = Double.parseDouble(request.getParameter("altura"));
			geratriz = Double.parseDouble(request.getParameter("geratriz"));
			util.construirSolido(new ConeBuilder(raio, altura, geratriz), session);
		}catch (Exception e) {
			throw new NumberFormatException("Erro na conversão númerica");
		}
		
		util.parameterMap(request, session);
		
		response.sendRedirect(ADDRESS);
	}


}
