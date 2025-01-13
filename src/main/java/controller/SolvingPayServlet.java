package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.CartItem;
import models.Customer;
import models.OrderDate;
import models.OrderDetails;
import models.OrderItem;
import models.OrderState;
import models.Orders;
import models.PaymentMethod;
import models.Product;
import models.Voucher;
import services.AccountServices;
import services.PayServices;
import services.ProductService;

@WebServlet("/solving")
public class SolvingPayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId =Integer.parseInt(req.getSession().getAttribute("id").toString());
		Account account = AccountServices.getAccount(accountId);
		Integer cusId = account.getCustomer().getId();
		
		List<CartItem> cartItems = PayServices.getCartItem(cusId);
		
		// Tao OrderItem
		List<OrderItem> orderItems = new ArrayList<>();
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setQuantity(cartItem.getQuantity());
		}
		
		// Tao Order Date
		OrderState orderState  = PayServices.getOrderState(1);
		OrderDate orderDate = new OrderDate();
		List<OrderDate> orderDateList = new ArrayList<OrderDate>();
		orderDate.setDate(LocalDateTime.now());
		orderDate.setOrderState(orderState);
	
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setPaymentMethod(PayServices.getPaymentMethod(3));
		Voucher voucher = (Voucher) req.getSession().getAttribute("voucher");
		orderDetails.setVoucher(voucher);
		orderDetails.setOrderItems(orderItems);
		orderDetails.setOrderDates(orderDateList);
		orderDateList.add(orderDate);
		
		// Tao orders
		Orders order = new Orders();
		order.setCustomer(account.getCustomer());
		order.setOrderDetails(orderDetails);
		order.setTotalAmount(orderDetails.calculateTotalAmount());
		PayServices.saveOrders(order);
		
		
	}
}
