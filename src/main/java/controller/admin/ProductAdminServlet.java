package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductViewModel;
import models.Product;
import services.AdminService;
import services.ProductService;

@WebServlet("/admin/product")
public class ProductAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = null;
		try {
			product = ProductService.findProduct(Integer.parseInt(req.getParameter("id")));
		} catch (NumberFormatException e) {
		}
		req.setAttribute("productViewModel", new ProductViewModel(product, AdminService.getAllBrands(),
				AdminService.getAllCategories(), AdminService.getAllAttributes()));
		req.getRequestDispatcher("/views/admin/productView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String stockStr = request.getParameter("stock");
		String discountStr = request.getParameter("discount");
		String description = request.getParameter("description");
		String categoryIdStr = request.getParameter("categoryId");
		String brandIdStr = request.getParameter("brandId");
		int id = Integer.parseInt(idStr);
		double price = Double.parseDouble(priceStr);
		int stock = Integer.parseInt(stockStr);
		double discount = Double.parseDouble(discountStr);
		int categoryId = Integer.parseInt(categoryIdStr);
		int brandId = Integer.parseInt(brandIdStr);
		Product product = id == -1 ? new Product() : ProductService.findProduct(id);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDiscount(discount);
		product.setDescription(description);
		product.setCategory(ProductService.getCategory(categoryId));
		product.setBrand(ProductService.getBrand(brandId));
		AdminService.saveOrUpdateProduct(product);
		resp.sendRedirect("/admin");
	}
}
