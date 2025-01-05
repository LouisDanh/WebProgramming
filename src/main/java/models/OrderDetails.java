package models;

import java.io.Serializable;
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
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = -18167224923213724L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "VOUCHER_ID")
	private Voucher voucher;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "DETAILS_ID", nullable = false)
	private List<OrderDate> orderDates;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detail")
	private List<OrderItem> orderItems;
	@ManyToOne
	@JoinColumn(name="PAYMENT_ID")
	private PaymentMethod paymentMethod;

}
