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

/**
 * OBS: Para simular ataque basta comentar o WebFilter
 * 
 */

@WebFilter( urlPatterns = { "/*" }, 
			dispatcherTypes = {
					DispatcherType.REQUEST, 
					DispatcherType.FORWARD 
			})
public class XSSFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
	}

	public void destroy() {}

	public void init(FilterConfig fConfig) throws ServletException {}

}
