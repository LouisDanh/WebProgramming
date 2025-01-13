package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import services.AccountServices;
import utils.AccountUtil;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        System.out.println("Token"+ token);
        Account account = AccountServices.getAccountByResetToken(token);
        System.out.println("Account: "+account );
        if (account != null) {
            if (account.getResetTokenExpirationTime().isBefore(LocalDateTime.now())) {
                response.getWriter().write("Token reset mật khẩu đã hết hạn.");
                return;
            }

            request.setAttribute("token", token);
            request.getRequestDispatcher("/views/login/resetPassword.jsp").forward(request, response);
        } else {
            response.getWriter().write("Token reset mật khẩu không AAAAAAAAAAAA.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("newPassword");

        Account account = AccountServices.getAccountByResetToken(token);
        if (account != null) {
            if (account.getResetTokenExpirationTime().isBefore(LocalDateTime.now())) {
                response.getWriter().write("Token reset mật khẩu đã hết hạn.");
                return;
            }

            String hashedPassword = AccountUtil.hashPassword(newPassword);
            account.setPassword(hashedPassword);
            account.setResetToken(null);  

            AccountServices.updateAccount(account);

            response.getWriter().write("Update successfully.");
        } else {
            response.getWriter().write("Token reset mật khẩu không hợp lệ.");
        }
    }
}

