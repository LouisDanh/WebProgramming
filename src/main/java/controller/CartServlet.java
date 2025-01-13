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
import models.id.CartItemId;
import services.AccountServices;
import services.PayServices;
import services.ProductService;

@WebServlet("/customer/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = Integer.parseInt(req.getSession().getAttribute("id").toString());
		Account account = AccountServices.getAccount(accountId);
		Integer cusId = account.getCustomer().getId();
		List<CartItem> cartItems = PayServices.getCartItem(cusId);
		try {
			Integer idProduct = Integer.parseInt(req.getParameter("id"));
			boolean contain = false;
			CartItem cartItem = null;
			for (CartItem c : cartItems) {
				if (c.getProduct().getId() == idProduct) {
					contain = true;
					c.setQuantity(c.getQuantity() + 1);
					cartItem = c;
					PayServices.updateCartItem(cartItem);
					break;
				}
			}
			if (!contain) {
				cartItem = new CartItem();
				CartItemId cartId = new CartItemId();
				cartId.setCusId(cusId);
				cartId.setProductId(idProduct);
				cartItem.setId(cartId);
				cartItem.setProduct(ProductService.getProduct(idProduct));
				cartItem.setQuantity(1);
				cartItem.setCustomer(account.getCustomer());
				PayServices.addCartItem(cartItem);
			}
		} catch (Exception e) {
		}
		req.setAttribute("cartItems", cartItems);
		req.getRequestDispatcher("/views/home/cart.jsp").forward(req, resp);
	}

}
