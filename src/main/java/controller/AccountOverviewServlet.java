package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import services.AccountServices;

@WebServlet("/profiles")
public class AccountOverviewServlet extends HttpServlet {
    private AccountServices accountService;

    @Override
    public void init() throws ServletException {
        accountService = new AccountServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer accountId = 2; // Lấy từ session 
        Account account = accountService.getAccount(accountId);
        if (account != null) {
            req.setAttribute("account", account);
            req.getRequestDispatcher("views/profile/profile.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Account not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer accountId = 2;  // Lấy từ session 
        Account account = accountService.getAccount(accountId);

        if (account == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Account not found");
            return;
        }

        String action = req.getParameter("action");
        if ("updateInfo".equals(action)) {
            if (updateAccountInfo(req, account)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update account");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not found");
        }
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

        return accountService.updateAccount(account);
    }
}
