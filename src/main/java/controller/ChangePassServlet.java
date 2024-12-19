package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import services.AccountServices;

/**
 * Servlet implementation class ChangePassServlet
 */
@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer userId = (Integer) req.getSession().getAttribute("userId");

		Account accont = AccountServices.getAccount(userId);
		req.setAttribute("account", accont);

		req.getRequestDispatcher("views/login/profile.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String currentPass = request.getParameter("current-password");
		String newPass = request.getParameter("new-password");
		String confirmPass = request.getParameter("confirm-password");

		Integer userId = (Integer) request.getSession().getAttribute("userId");

		Account accont = AccountServices.getAccount(userId);

		accont.setPassword(newPass);
		accont.setPassword(confirmPass);

		Boolean isUpdate = AccountServices.updateAccount(accont);
		if (isUpdate) {
			if (newPass.equals(confirmPass)) {
				// Thông báo đổi mk thành công
			} else {
				// đổi ko thành công
			}
		}else {
			// Đổi ko thành công
		}

	}

}
