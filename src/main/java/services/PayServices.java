package services;

import dao.GenericDao;
import models.OrderState;
import models.Orders;
import models.PaymentMethod;
import models.ProductCategory;
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
		return GenericDao.insert(order, true);
	}
}
