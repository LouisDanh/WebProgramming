package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	 Cấu hình liên kết
	@ManyToOne
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	private PaymentMethod paymentMethod;
	@ManyToOne
	@JoinColumn(name = "VOUCHER_ID")
	private Voucher voucher;
	@OneToMany( fetch = FetchType.LAZY)
	@JoinColumn(name="ORDER_ID",nullable = false)
	private List<OrderDate> orderDates;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
	private List<OrderItem> orderItems;

}
