package br.edu.utfpr.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RegexRequestWrapper extends HttpServletRequestWrapper {
       
    public RegexRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String getParameter(String name) {
    	
    	/** [^\\w] -> metacaracter - Buscar qualquer caracter de letras e números e underscore */
    	String param = super.getParameter(name);
    	param = param.replaceAll("[^\\w]", "");
    	
    	return param;
    }
}
