package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/a/home", "/a" })
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/admin/index.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

}
