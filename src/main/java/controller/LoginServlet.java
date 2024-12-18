package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Customer;
import services.AccountServices;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedWith = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestedWith)) {
			checkEmail(request, response);
		} else {
			String action = request.getParameter("action");
			if ("create".equalsIgnoreCase(action))
				if (createAccount(request, response))
					response.sendRedirect("views/login/login.jsp");
				else {
					request.getRequestDispatcher("views/login/register.jsp").forward(request, response);
				}
			else
				login(request, response);
		}
	}

	private void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		Integer id = AccountServices.getIdAccount(email);
		if (id != null) {
			request.setAttribute("id", id);
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
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		Customer customer = new Customer(fullName, tel);
		Account account = new Account(email, password, customer);
		return AccountServices.createAccount(account);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("id") != null) {
			String password = request.getParameter("password");
			if (AccountServices.login((Integer) request.getAttribute("id"), password))
				response.sendRedirect("views/home/home.jsp");
		} else {
			request.setAttribute("loginFail", "Incorrect username or email");
			request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
		}
	}

}
