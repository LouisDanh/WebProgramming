package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import services.ProductService;

@WebServlet("/home/product/descript")
public class DescriptProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer idProduct = Integer.parseInt(req.getParameter("id"));
			Product product = ProductService.findProduct(idProduct);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/home/descript.jsp").forward(req, resp);
		} catch (NumberFormatException | NullPointerException e) {
			resp.sendRedirect("/home");
		}
	}
}
