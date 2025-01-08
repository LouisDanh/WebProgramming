package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import models.ProductCategory;
import services.ProductService;

@WebFilter("/views/*")
public class HeaderFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		List<ProductCategory> data = ProductService.getChildCategory(null);
		request.setAttribute("categories", data);
		chain.doFilter(request, response);
	}
}
