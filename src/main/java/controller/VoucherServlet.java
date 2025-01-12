package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Voucher;
import services.ProductService;
@WebServlet("/voucher")
public class VoucherServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeVoucher = req.getParameter("voucher");
		Voucher voucherCheck = ProductService.checkVoucherCode(codeVoucher);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
        if (voucherCheck != null) {
        	req.getSession().setAttribute("voucher", voucherCheck);
            out.write("{\"status\":\"success\", \"message\":\"Voucher applied successfully!\"}");
        } else {
            out.write("{\"status\":\"error\", \"message\":\"Invalid voucher code!\"}");
        }

        out.flush();
    }
		
	
}

