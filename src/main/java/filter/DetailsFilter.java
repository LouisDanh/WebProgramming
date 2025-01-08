package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import services.ProductService;

@WebFilter("/views/home/descript.jsp")
public class DetailsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Integer idProduct = Integer.parseInt(request.getParameter("id"));
			Product product = ProductService.findProduct(idProduct);
			request.setAttribute("product", product);
			chain.doFilter(request, response);
		} catch (NumberFormatException | NullPointerException e) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("home.jsp");
		}
	}

}
