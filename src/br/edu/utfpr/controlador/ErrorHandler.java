package br.edu.utfpr.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/error-handler")
public class ErrorHandler extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		Throwable throwable = (Throwable)
				request.getAttribute("javax.servlet.error.exception");

		Integer statusCode = (Integer)
				request.getAttribute("javax.servlet.error.status_code");

		Class exceptionType = (Class)request.getAttribute("javax.servlet.error.exception_type");

		String servletName = (String)
				request.getAttribute("javax.servlet.error.servlet_name");		
		if (servletName == null){
			servletName = "Unknown";
		}

		String requestUri = (String)
				request.getAttribute("javax.servlet.error.request_uri");		
		if (requestUri == null){
			requestUri = "Unknown";
		}

		// Set response content type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Informacao Erro/Excecao";
		String docType =
				"<!doctype>\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n");

		if (throwable == null && statusCode == null){
			out.println("<h2>Nao ha informacao sobre o erro :(</h2>");
			out.println("Por favor, retorne para <a href=\"" + 
					response.encodeURL("http://localhost:8080/") + 
					"\">Inicial</a>.");
		}
		else if (statusCode != null){
			out.println("O codigo do status HTTP eh: " + statusCode);
			out.println("type: " + exceptionType);

			out.println("Nome do Servlet : " + servletName + 
					"</br></br>");
			out.println("Tipo de Excecao : " + 
					throwable.getClass( ).getName( ) + 
					"</br></br>");
			out.println("URI da Requisicao: " + requestUri + 
					"<br><br>");
			out.println("Mensagem da Excecao: " + 
					throwable.getMessage());
		}
		else{
			out.println("<h2>Informacao de Erro</h2>");

			out.println("type: " + exceptionType);

			out.println("Nome do Servlet : " + servletName + 
					"</br></br>");
			out.println("Tipo de Excecao : " + 
					throwable.getClass( ).getName( ) + 
					"</br></br>");
			out.println("URI da Requisicao: " + requestUri + 
					"<br><br>");
			out.println("Mensagem da Excecao: " + 
					throwable.getMessage( ));
		}
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		doGet(request, response);
	}
}