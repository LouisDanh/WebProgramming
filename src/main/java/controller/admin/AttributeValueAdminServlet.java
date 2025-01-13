package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AttributeValue;
import services.AdminService;

@WebServlet("/admin/attribute-value")
public class AttributeValueAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			AttributeValue attributeValue = AdminService.getAttributeValue(id);
			req.setAttribute("attributeValue", attributeValue);
		} catch (NumberFormatException e) {
		}
		List<AttributeValue> attributeValues = AdminService.getAllAttributeValues();
		req.setAttribute("attributeValues", attributeValues);
		req.getRequestDispatcher("/views/admin/attributeValueView.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String value = req.getParameter("value");
		AttributeValue attributeValue = id == -1 ? new AttributeValue() : AdminService.getAttributeValue(id);
		attributeValue.setValue(value);
		AdminService.saveOrUpdateAttributeValue(attributeValue);
		resp.sendRedirect("/WebMyPham/admin");

	}
}
