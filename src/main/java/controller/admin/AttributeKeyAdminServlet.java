package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AttributeKey;
import services.AdminService;

@WebServlet("/admin/attribute-key")
public class AttributeKeyAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			AttributeKey attributeKey = AdminService.getAttributeKey(id);
			req.setAttribute("attributeKey", attributeKey);
		} catch (NumberFormatException e) {
		}
		List<AttributeKey> attributeKeys = AdminService.getAllAttributeKeys();
		req.setAttribute("attributeKeys", attributeKeys);
		req.getRequestDispatcher("/views/admin/attributeKeyView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		AttributeKey attributeKey = id == -1 ? new AttributeKey() : AdminService.getAttributeKey(id);
		attributeKey.setName(name);
		AdminService.saveOrUpdateAttributeKey(attributeKey);
		resp.sendRedirect("/WebMyPham/admin");
	}
}
