package br.edu.utfpr.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RegexFormSolidoRequestWrapper extends HttpServletRequestWrapper {
	private static final long serialVersionUID = 1L;
       
    public RegexFormSolidoRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
    
    @Override
    public String getParameter(String name) {
    	
    	/** [^.0-9] -> metacaracter - Busca qualquer caracter que não seja número e ponto */
    	String param = super.getParameter(name);
    	param = param.replaceAll("[^.0-9]", "");
    	
    	return param;
    }

}
