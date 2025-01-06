package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LayoutFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		if (path.equals(contextPath + "/views/shares/layout.jsp") || path.contains("/resources/")) {
			chain.doFilter(request, response);
			return;
		}

		boolean containHeader = true;
		boolean containFooter = true;
		System.out.println(path);
		System.out.println(httpRequest.getContextPath() + "/");
		if (path.equals(httpRequest.getContextPath() + "/")) {
			path += "views/home/home.jsp";
		} else if (path.contains("/admin/") || path.contains("/shares/")) {
			containHeader = false;
			containFooter = false;
		} else if (path.contains("/login/")) {
			containFooter = false;
		}
		request.setAttribute("containHeader", containHeader);
		request.setAttribute("containFooter", containFooter);
		String contentPath = path.substring(path.indexOf("/views/"));
		request.setAttribute("contentPage", contentPath);
		request.getRequestDispatcher("/views/shares/layout.jsp").forward(request, response);
	}

}
