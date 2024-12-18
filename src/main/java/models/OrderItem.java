package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 5144383351715767229L;

	@EmbeddedId
	private OrderItemId id;
	
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
	@Column(name="RATING")
	private int rating;
//	 Cấu hình liên kết
	@ManyToOne()
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID",nullable = false)
	private Product product;
	@ManyToOne()
	@MapsId("orderId")
	@JoinColumn(name = "ORDER_ID",nullable = false)
	private Order order;

}
