package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Customer;
import services.AccountServices;
import services.ProductService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("loginFail");
		String action = request.getParameter("action");
		if ("create".equalsIgnoreCase(action))
			if (createAccount(request, response)) {
				response.sendRedirect("views/login/login.jsp");
			} else {
				request.getRequestDispatcher("views/login/register.jsp").forward(request, response);
			}
		else {
			login(request, response);
		}
	}

	private boolean createAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		if (AccountServices.getIdAccount(email) != null) {
			request.setAttribute("emailError", "Email already exist");
			return false;
		}
		String fullName = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		Customer customer = new Customer(fullName, phone);
		Account account = new Account(email, password, customer);
		return AccountServices.createAccount(account);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Integer  id = AccountServices.login(email, password);
		if (id != null) {
			request.getServletContext().setAttribute("parentType", ProductService.getTypes());
			request.getSession().setAttribute("id", id);
			response.sendRedirect("views/home/home.jsp");
		} else {
			request.setAttribute("loginFail", "Invalid email or password. Please try again.");
			request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
		}
	}

}
