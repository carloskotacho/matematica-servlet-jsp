package br.edu.utfpr.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
public class FlashScopeFilter implements Filter {

	private static final String FLASH_SESSION_KEY = "FLASH_SESSION_KEY";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// reinstate any flash scoped params from the users session
		// and clear the session
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession(true);
			if (session != null) {
				Map<String, Object> flashParams = (Map<String, Object>) session.getAttribute(FLASH_SESSION_KEY);
				if (flashParams != null) {
					for (Map.Entry<String, Object> flashEntry : flashParams.entrySet()) {
						request.setAttribute(flashEntry.getKey(), flashEntry.getValue());
					}
					session.removeAttribute(FLASH_SESSION_KEY);
				}
			}
		}

		// process the chain
		chain.doFilter(request, response);

		// store any flash scoped params in the user's session for the
		// next request
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Map<String, Object> flashParams = new HashMap();
			Enumeration e = httpRequest.getAttributeNames();
			while (e.hasMoreElements()) {
				String paramName = (String) e.nextElement();
				if (paramName.startsWith("flash.")) {
					Object value = request.getAttribute(paramName);
					paramName = paramName.substring(6, paramName.length());
					flashParams.put(paramName, value);
				}
			}
			if (flashParams.size() > 0) {
				HttpSession session = httpRequest.getSession(true);
				session.setAttribute(FLASH_SESSION_KEY, flashParams);
			}
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// no-op
	}

	public void destroy() {
		// no-op
	}
}
