package services;

import java.util.List;

import dao.GenericDao;
import models.CartItem;
import models.OrderState;
import models.Orders;
import models.PaymentMethod;
import utils.QueryUtil;

public class PayServices {
	public static OrderState getOrderState(Integer id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(OrderState.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(OrderState.class, OrderState.class, query, id);
	}

	public static PaymentMethod getPaymentMethod(Integer id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(PaymentMethod.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(PaymentMethod.class, PaymentMethod.class, query, id);
	}

	/**
	 * Luu orders
	 */
	public static boolean saveOrders(Orders order) {
		GenericDao.insert(order.getOrderDetails(), true);
		return GenericDao.insert(order, true);
	}

	public static boolean addCartItem(CartItem item) {
		return GenericDao.insert(item, true);
	}

	public static void updateCartItem(CartItem cartItem) {
		GenericDao.update(cartItem, true);
	}

	/**
	 * Lấy Orders
	 */
	public static List<Orders> getOrders(Integer cusId) {
		String condition = QueryUtil.createCondition("customer.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Orders.class, QueryUtil.ALL, condition);

		List<Orders> orders = GenericDao.excuteQueryGetList(Orders.class, Orders.class, query, cusId);
		return orders;
	}

	public static List<CartItem> getCartItem(Integer cusId) {
		String condition = QueryUtil.createCondition("customer.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(CartItem.class, QueryUtil.ALL, condition);
		List<CartItem> cartItems = GenericDao.excuteQueryGetList(CartItem.class, CartItem.class, query, cusId);
		return cartItems;
	}

}
