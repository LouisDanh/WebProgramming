package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Customer;
import services.AccountServices;
import services.AdminService;
import utils.AccountUtil;

@WebServlet("/admin/account")
public class AccountAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("ban") != null) {
			AdminService.setBan(Integer.parseInt(req.getParameter("id")),Boolean.parseBoolean(req.getParameter("ban")));
		}
		List<Account> accounts = AdminService.getAllAccounts();
		req.setAttribute("accounts", accounts);
		resp.sendRedirect("/WebMyPham/admin");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String fullName = req.getParameter("fullName");
		String phone = req.getParameter("phone");
		String role = req.getParameter("role");
		Account acc = new Account();
		acc.setPassword(password);
		acc.setRole(Integer.parseInt(role));
		acc.setEmail(email);
		acc.setCustomer(new Customer(fullName, phone));
		AccountServices.createAccount(acc);
		resp.sendRedirect("/WebMyPham/admin");
	}
}
