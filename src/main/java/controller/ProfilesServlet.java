package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import models.Account;
import models.OrderDetails;
import models.OrderItem;
import models.Orders;
import services.AccountServices;
import services.PayServices;
import services.ProductService;
import utils.AccountUtil;

@WebServlet("/customer/profiles")
public class ProfilesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = Integer.parseInt(req.getSession().getAttribute("id").toString());
		Account account = AccountServices.getAccount(accountId);
		if (account == null) {
			JSONObject responseJson = new JSONObject();
			responseJson.put("status", "error");
			responseJson.put("message", "Account not found");
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.setContentType("application/json");
			resp.getWriter().write(responseJson.toString());
			req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
		}

		Integer cusId = account.getCustomer().getId();
		List<Orders> orders = PayServices.getOrders(cusId);
		req.setAttribute("account", account);
		req.setAttribute("orders", orders);

		req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = Integer.parseInt(req.getSession().getAttribute("id").toString());
		Account account = AccountServices.getAccount(accountId);
		JSONObject responseJson = new JSONObject();

		if (account == null) {
			responseJson.put("status", "error");
			responseJson.put("message", "Account not found");
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			String action = req.getParameter("action");

			switch (action) {
			case "updateInfo":
				if (updateAccountInfo(req, account)) {
					responseJson.put("status", "success");
					responseJson.put("message", "Account info updated successfully!");
				} else {
					responseJson.put("status", "error");
					responseJson.put("message", "Failed to update account");
				}
				break;

			case "changePass":
				if (changePassword(req, account)) {
					responseJson.put("status", "success");
					responseJson.put("message", "Change password successfully!");
				} else {
					responseJson.put("status", "error");
					responseJson.put("message", "Failed to change password. Please check your current password.");
				}
				break;

			case "orderHistory":
				if (orderHistory(req, account)) {

				}

			default:
				responseJson.put("status", "error");
				responseJson.put("message", "Action not found");
				break;
			}
		}

		resp.setContentType("application/json");
		resp.getWriter().write(responseJson.toString());
	}

	private boolean orderHistory(HttpServletRequest req, Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean updateAccountInfo(HttpServletRequest req, Account account) {
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		account.getCustomer().setFullName(fullName);
		account.setEmail(email);
		account.getCustomer().setPhone(phone);
		account.getCustomer().setPlaceReceive(address);

		return AccountServices.updateAccount(account);
	}

	private boolean changePassword(HttpServletRequest req, Account account) {
		String currentPassword = req.getParameter("current-password");
		String newPassword = req.getParameter("new-password");
		String confirmPassword = req.getParameter("confirm-password");

		if (currentPassword == null || !account.checkPassword(account.getId(), currentPassword)) {
			return false;
		}

		if (newPassword == null || !newPassword.equals(confirmPassword)) {
			return false;
		}

		// Mã hóa mật khẩu
		String hashedPassword = AccountUtil.hashPassword(newPassword);
		account.setPassword(hashedPassword);

//		account.setPassword(newPassword);
		return AccountServices.updateAccount(account);
	}
}
