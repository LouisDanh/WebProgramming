package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import models.Topic;
import services.ProductService;
@WebFilter("/views/home/home.jsp")
public class HomeFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Object topics = req.getAttribute("topics");
		if (topics == null) {
			List<Topic> data = ProductService.getAllTopic();
			req.setAttribute("topics", data);
		}
		chain.doFilter(req, res);
	}

}
