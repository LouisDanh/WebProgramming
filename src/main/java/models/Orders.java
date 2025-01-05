package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable{
	private static final long serialVersionUID = -8145256353326935319L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TOTAL_AMOUNT",nullable = false)
	private double totalAmount;
//	 Cấu hình liên kết
	@OneToOne
	@JoinColumn(name="ORDER_DETAILS_ID")
	private OrderDetails orders;
}
