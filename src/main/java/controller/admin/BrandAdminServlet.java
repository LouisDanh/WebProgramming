package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AttributeValue;
import models.Brand;
import services.AdminService;

@WebServlet("/admin/brand")
public class BrandAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Brand brand = AdminService.getBrand(id);
			req.setAttribute("brand", brand);
		} catch (Exception e) {
		}
		req.getRequestDispatcher("/views/admin/brandView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Brand brand = id == -1 ? new Brand() : AdminService.getBrand(id);
		brand.setName(name);
		AdminService.saveOrUpdateBrand(brand);
		resp.sendRedirect("/WebMyPham/admin");

	}
}
