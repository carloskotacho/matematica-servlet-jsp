package br.edu.utfpr.util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.builder.MatematicaDirector;
import br.edu.utfpr.builder.SolidoBuilder;
import br.edu.utfpr.model.SolidoProduct;

public class Util {
	
	public Util() {}
	
	public void construirSolido(SolidoBuilder solido, HttpSession session) throws ServletException, IOException {
		MatematicaDirector matematica = new MatematicaDirector( solido );
		matematica.construirSolido();
		SolidoProduct solidoBean = matematica.getSolido();
		session.setAttribute("bean", solidoBean);
	}
	
	public void parameterMap(HttpServletRequest request, HttpSession session) {
		Map<String, String[]> parameterMap = new LinkedHashMap<String, String[]>();
		parameterMap.putAll(request.getParameterMap());
		session.setAttribute("parameterMap", parameterMap);
	}

}
