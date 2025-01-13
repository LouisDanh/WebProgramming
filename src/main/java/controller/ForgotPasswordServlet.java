package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import services.AccountServices;
import utils.EmailUtil;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		Account account = AccountServices.checkAccountByEmail(email);
		if (account != null) {
			String resetToken = UUID.randomUUID().toString();
			System.out.println(resetToken);
			LocalDateTime expirationTime = LocalDateTime.now().plusHours(1); // Token hết hạn sau 1 giờ

			account.setResetToken(resetToken);
			System.out.println();
			account.setResetTokenExpirationTime(expirationTime);
			AccountServices.updateAccount(account);
			System.out.println("tokenReset: "+account.getResetToken());

			String subject = "Yêu cầu đặt lại mật khẩu";
			String body = "Để đặt lại mật khẩu, vui lòng nhấn vào link sau:\n"
					+ "http://localhost:8080/WebMyPham/ResetPasswordServlet?token=" + resetToken;

			EmailUtil.sendEmail(email, subject, body);

			response.getWriter().write("Link reset password send successfully.");
		} else {
			response.getWriter().write("Email không tồn tại.");
		}
	}
}