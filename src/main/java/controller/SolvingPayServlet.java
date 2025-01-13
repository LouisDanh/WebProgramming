package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.CartItem;
import models.OrderDate;
import models.OrderDetails;
import models.OrderItem;
import models.OrderState;
import models.Orders;
import models.Voucher;
import models.id.OrderItemId;
import services.AccountServices;
import services.PayServices;
import services.ProductService;

@WebServlet("/solving")
public class SolvingPayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = Integer.parseInt(req.getSession().getAttribute("id").toString());
		Account account = AccountServices.getAccount(accountId);
		Integer cusId = account.getCustomer().getId();
		List<CartItem> cartItems = PayServices.getCartItem(cusId);
		if (!cartItems.isEmpty()) {
			// Tao OrderItem
			List<OrderItem> orderItems = new ArrayList<>();
			OrderDetails orderDetails = new OrderDetails();
			for (CartItem cartItem : cartItems) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(new OrderItemId());
				orderItem.setProduct(cartItem.getProduct());
				orderItem.setDetail(orderDetails);
				orderItem.setQuantity(cartItem.getQuantity());
				orderItems.add(orderItem);
			}
			// Tao Order Date
			OrderState orderState = PayServices.getOrderState(1);
			OrderDate orderDate = new OrderDate();
			List<OrderDate> orderDateList = new ArrayList<OrderDate>();
			orderDate.setDate(LocalDateTime.now());
			orderDate.setOrderState(orderState);
			orderDateList.add(orderDate);
			orderDetails.setPaymentMethod(PayServices.getPaymentMethod(1));
			Voucher voucher = (Voucher) req.getSession().getAttribute("voucher");
			orderDetails.setVoucher(voucher);
			orderDetails.setOrderItems(orderItems);
			orderDetails.setOrderDates(orderDateList);
			// Tao orders
			Orders order = new Orders();
			order.setCustomer(account.getCustomer());
			order.setOrderDetails(orderDetails);
			order.setTotalAmount(orderDetails.calculateTotalAmount());
			if (PayServices.saveOrders(order)) {
				PayServices.clearCart(cusId);
			}
		}
		resp.sendRedirect("/WebMyPham/home");

	}
}
