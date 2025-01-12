package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dto.FilterViewModel;
import services.ProductService;

@WebFilter("/home/product/category")
public class ProductFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String parentIdString = request.getParameter("parentId");
		if (request.getParameter("parentId") != null) {
			HttpServletRequest req = ((HttpServletRequest) request);
			req.getSession().setAttribute("parentId", parentIdString);
			Integer parentId = Integer.parseInt(parentIdString);
			FilterViewModel model = new FilterViewModel();
			req.getSession().setAttribute("mappingAttributes",
					model.loadAttribute(ProductService.getProductByCategory(parentId)));
		}
		chain.doFilter(request, response);
	}
}
