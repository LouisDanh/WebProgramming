package controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Voucher;
import services.AdminService;
import services.VoucherService;

@WebServlet("/admin/voucher")
public class VoucherAdminServlet extends HttpServlet {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	List<Voucher> voucher = AdminService.getAllVouchers();
		req.setAttribute("voucher", voucher);
		resp.sendRedirect("/WebMyPham/admin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        Double percentage = Double.parseDouble(req.getParameter("percentage"));
        Double maxDiscount = Double.parseDouble(req.getParameter("maxDiscount"));
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        String code = req.getParameter("code");
        String expiredDateStr = req.getParameter("expiredDate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime expiredDate = LocalDateTime.parse(expiredDateStr, formatter);

        Voucher voucher = new Voucher();
        voucher.setName(name);
        voucher.setPercentage(percentage);
        voucher.setMaxDiscount(maxDiscount);
        voucher.setQuantity(quantity);
        voucher.setCode(code);
        voucher.setExpiredDate(expiredDate);

        VoucherService.createVoucher(voucher);
        resp.sendRedirect("/WebMyPham/admin/voucher");
    }
}