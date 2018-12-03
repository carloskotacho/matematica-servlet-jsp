package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ADMINISTRADOR = "ADMINISTRADOR";
	private static final String USUARIO = "USUARIO";
	private static final String ADMIN_INDEX = "a/home";
	private static final String USER_INDEX = "u/home";

	private Boolean isAdministrador;

    public LoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = "/form-login.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		
		try {
			request.login(login, pwd);
		}catch (Exception e) {
			response.sendRedirect("login");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("estaLogado", true);
		
		String usuarioCorrente = request.getRemoteUser();
		addCookie("usuarioCorrente", usuarioCorrente, -1, response);
		
		addCookie("senhaUsuario", pwd, -1, response);
		
		String roleUser;
		if(request.isUserInRole(ADMINISTRADOR)) {
			roleUser = ADMINISTRADOR;
			isAdministrador = true;
		}else {
			roleUser = USUARIO;
			isAdministrador = false;
		}
		
		session.setAttribute("isAdministrador", isAdministrador);
		
		request.getServletContext().setAttribute("roleUser", roleUser);
		
		enviaCookieUsuario(login, response);
		
		
		String address = "";
		address += (roleUser.equals(ADMINISTRADOR) ? ADMIN_INDEX : USER_INDEX);
		response.sendRedirect(address);
		
	}
	
	private void addCookie(String nome, String valor, int t, HttpServletResponse response) {
		Cookie c = new Cookie(nome, valor);
		c.setMaxAge(t);
		response.addCookie(c);
	}
	
	private void enviaCookieUsuario(String login, HttpServletResponse response) {
		if(!login.isEmpty()) {
			Cookie cookieLogin = new Cookie("login", login);
			cookieLogin.setMaxAge(60*60*24*7);// 7 dias
			response.addCookie(cookieLogin);
		}
	}
	


}
