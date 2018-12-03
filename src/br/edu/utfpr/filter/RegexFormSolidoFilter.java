package br.edu.utfpr.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
				, urlPatterns = { "/u/cubo", "/u/cilindro", "/u/cone", "/u/piramide" }, 
						servletNames = { "SolidoServlet" })
public class RegexFormSolidoFilter implements Filter {

    public RegexFormSolidoFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(new RegexFormSolidoRequestWrapper((HttpServletRequest) request), response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
