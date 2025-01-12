package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import services.ProductService;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = -18167224923213724L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "VOUCHER_ID")
	private Voucher voucher;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "orderDetails")
	private List<OrderDate> orderDates;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detail")
	private List<OrderItem> orderItems;
	@ManyToOne
	@JoinColumn(name = "PAYMENT_ID")
	private PaymentMethod paymentMethod;

	// Getter và Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public List<OrderDate> getOrderDates() {
		return orderDates;
	}

	public void setOrderDates(List<OrderDate> orderDates) {
		this.orderDates = orderDates;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Mặc định là thanh toán tiền mặt
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if (paymentMethod == null || !paymentMethod.getName().equals("Cash on Delivery")) {
			PaymentMethod cashOnDelivery = new PaymentMethod();
			cashOnDelivery.setName("Cash on Delivery");
			cashOnDelivery.setDiscount(0.00);
			this.paymentMethod = cashOnDelivery;
		} else {
			this.paymentMethod = paymentMethod;
		}
	}

	/**
	 * Tính tổng số tiền của đơn hàng từ các OrderItem.
	 */
	public double calculateTotalAmount() {
		double totalAmount = 0.0;
		for (OrderItem item : orderItems) {
			double itemPrice = item.getProduct().getPrice();
			int quantity = item.getQuantity();
			totalAmount += itemPrice * quantity;
		}

		return totalAmount;
	}

	/**
	 * Áp dụng voucher nếu có và tính lại tổng số tiền.
	 */
	public double applyVoucher(double totalAmount) {
		if (voucher != null) {
			double discountPercentage = voucher.getPercentage();
			totalAmount = totalAmount * (1 - discountPercentage / 100);
		}

		return totalAmount;
	}
}
