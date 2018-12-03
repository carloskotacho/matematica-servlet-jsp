package br.edu.utfpr.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, 
		   urlPatterns = { "/form-login.jsp" })
public class SessaoFilter implements Filter {
	
	private final static String ADMINISTRADOR = "ADMINISTRADOR";
	private static final String ADMIN_INDEX = "/a/home";
	private static final String USUARIO_INDEX = "/u/home";

    public SessaoFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		Boolean estaLogado = (Boolean) session.getAttribute("estaLogado");
		
		if (estaLogado == null) {
			
			chain.doFilter(request, response);
			
		} else {
			String roleUser = (String) ((HttpServletRequest)request).getServletContext().getAttribute("roleUser");
			
			if ( roleUser.equals(ADMINISTRADOR) )
				((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + ADMIN_INDEX);
			else
				((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + USUARIO_INDEX);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
