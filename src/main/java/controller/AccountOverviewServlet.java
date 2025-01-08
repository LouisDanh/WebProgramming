package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import services.AccountServices;

@WebServlet("/accountOverview")
public class AccountOverviewServlet extends HttpServlet{
	private AccountServices accountService;
	@Override
	public void init() throws ServletException {
		accountService = new AccountServices();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = 2; // Lấy từ session
		Account account = accountService.getAccount(accountId);
		if(account!=null) {
			req.setAttribute("account", account);
			req.getRequestDispatcher("views/profile/profile.jsp").forward(req, resp);
		}else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "account not found"); 
		}
	}

}
