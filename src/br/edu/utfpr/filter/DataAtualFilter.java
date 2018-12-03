package br.edu.utfpr.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class DataAtualFilter implements Filter {

    public DataAtualFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		salvarDataAtualRequest((HttpServletRequest)request);
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	
	private void salvarDataAtualRequest(HttpServletRequest request) {
		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		String dataAtual = formato.format(data);
		request.setAttribute("flash.dataAtual", dataAtual);
	}

}
