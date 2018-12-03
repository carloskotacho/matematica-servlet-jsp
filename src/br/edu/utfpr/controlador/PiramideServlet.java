package br.edu.utfpr.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.builder.PiramideBuilder;
import br.edu.utfpr.util.Util;

@WebServlet("/u/piramide")
public class PiramideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ADDRESS = "resultado";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = "/WEB-INF/view/forms/piramide-form.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		double altura = 0.0, ladoBase = 0.0, apotemaBase = 0.0, apotemaPiramide = 0.0;
		int tipoPiramide = 0;
		
		Util util = new Util();
		
		try {
			altura = Double.parseDouble(request.getParameter("altura"));
			ladoBase = Double.parseDouble(request.getParameter("ladoBase"));
			apotemaBase = Double.parseDouble(request.getParameter("apotemaBase"));
			apotemaPiramide = Double.parseDouble(request.getParameter("apotemaPiramide"));
			tipoPiramide = Integer.parseInt(request.getParameter("tipo-piramide"));
			util.construirSolido(new PiramideBuilder(altura, ladoBase, apotemaBase, apotemaPiramide, tipoPiramide), session);
		}catch (Exception e) {
			throw new NumberFormatException("Erro na conversão númerica");
		}
		
		util.parameterMap(request, session);
		
		response.sendRedirect(ADDRESS);
	}
}
