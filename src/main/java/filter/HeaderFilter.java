package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import models.ProductCategory;
import services.ProductService;

@WebFilter("/*")
public class HeaderFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI();
		int role = -1;
		if (uri.contains("/admin/")) {
			try {
				role = Integer.parseInt(request.getParameter("role"));
			} catch (Exception e) {
			}
		}
		if (role == 5 || role == -1) {
			Object obj = request.getAttribute("categories");
			if (obj == null) {
				List<ProductCategory> data = ProductService.getParentCategory(null);
				request.setAttribute("categories", data);
			}
		}
		chain.doFilter(request, response);
	}
}
