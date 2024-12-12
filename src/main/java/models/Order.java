package models;

import java.util.List;

public class Order {
	private int id;
	private List<OrderDate> orderDates;
	private PaymentMethod paymentMethod;
	private Voucher voucher;
	private List<OrderItem> orderItems;
	
}
