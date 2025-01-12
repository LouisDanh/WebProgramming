package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductCategory;
import services.AdminService;
import services.ProductService;

@WebServlet("/admin/category")
public class CategoryAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Fetch all categories for the dropdown list
		List<ProductCategory> categories = AdminService.getAllCategories();
		req.setAttribute("categories", categories);
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			ProductCategory category = AdminService.getCategory(id);
			req.setAttribute("category", category);
		} catch (NumberFormatException e) {
		}
		req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String parentId = req.getParameter("parentId");
		ProductCategory category = id == -1 ? new ProductCategory() : AdminService.getCategory(id);
		category.setName(name);
		category.setDescription(description);
		category.setParent(ProductService.getCategory(Integer.parseInt(parentId)));
		AdminService.saveOrUpdateCategory(category);
		resp.sendRedirect("/admin");
	}
}
