package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/a/credencial")
public class CredencialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String senha = "", usuario = "";
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("senhaUsuario")) {
				senha = cookie.getValue();
			}else if(cookie.getName().equals("usuarioCorrente")) {
				usuario = cookie.getValue();
			}
		}

		session.setAttribute("usuario", usuario);
		session.setAttribute("senha", senha);
		session.setAttribute("addr", request.getRemoteAddr());
		session.setAttribute("host", request.getRemoteHost());
		session.setAttribute("port", request.getRemotePort());
		
		String address = "/WEB-INF/view/admin/credencial.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
