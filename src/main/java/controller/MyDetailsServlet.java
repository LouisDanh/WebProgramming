package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenericDao;
import models.Customer;
import services.AccountServices;

/**
 * Servlet implementation class ProfileServices
 */
@WebServlet("/ProfileServices")
public class MyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Đảm bảo người dùng đã đăng nhập
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		Customer user = AccountServices.getCostomer(userId);
		request.setAttribute("customer", user);

		request.getRequestDispatcher("views/login/profile.jsp").forward(request, response);

		// Tạo một user để lấy dữ liệu(từ user ID)

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("full-name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		Integer userId = (Integer) req.getSession().getAttribute("userId");
		Customer customer = AccountServices.getCostomer(userId);

		customer.setFullName(fullName);
		customer.setPhone(phone);
		customer.setPlaceReceive(address);

		boolean isUpdated = AccountServices.updateCustomer(customer);
		if (!isUpdated) {
			// Hiển thị thông báo
		} else {
			// Hiển thị thông báo tiếp :>>>>
		}

	}

}
