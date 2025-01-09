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
public class ProfilesServlet extends HttpServlet {
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
        Integer accountId = 2; // Lấy từ session 
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
        } else if ("changePass".equals(action)) {
            if (changePassword(req, account)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to change password");
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

    private boolean changePassword(HttpServletRequest req, Account account) {
        // Lấy mật khẩu cũ, mật khẩu mới và mật khẩu xác nhận từ request
        String currentPassword = req.getParameter("current-password");
        String newPassword = req.getParameter("new-password");
        String confirmPassword = req.getParameter("confirm-password");

        // Kiểm tra mật khẩu cũ
        if (currentPassword == null || !accountService.checkPassword(account.getId(), currentPassword)) {
            return false; // Mật khẩu cũ không đúng
        }

        // Kiểm tra mật khẩu mới và xác nhận mật khẩu
        if (newPassword == null || !newPassword.equals(confirmPassword)) {
            return false; // Mật khẩu mới không khớp với xác nhận mật khẩu
        }

        // Cập nhật mật khẩu mới
        account.setPassword(newPassword);
        return accountService.updateAccount(account); // Cập nhật vào database
    }
}
