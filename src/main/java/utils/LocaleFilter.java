package utils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String lang = httpRequest.getParameter("lang");

		if (lang != null) {
			Locale locale = new Locale(lang);
			Locale.setDefault(locale);
			// Set the locale for the response
			response.setLocale(locale);
		}

		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
