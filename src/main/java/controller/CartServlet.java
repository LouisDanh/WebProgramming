package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.CartItem;
import models.OrderDetails;
import models.Orders;
import models.Voucher;
import services.AccountServices;
import services.ProductService;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = 2;
		Account account = AccountServices.getAccount(accountId);
		Integer cusId = account.getCustomer().getId();
		List<CartItem> cartItems = ProductService.getCartItem(cusId);
		
		req.setAttribute("cartItems", cartItems);
		
		// Ktra tra voucher hợp lệ hay không 
		req.getRequestDispatcher("/voucher");
		
	

		req.getRequestDispatcher("views/home/cart.jsp").forward(req, resp);

		
	}

}
