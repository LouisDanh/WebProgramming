package models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {
	@EmbeddedId
	private CartItemId id;
	@Column(name = "QUANTITY", nullable = false)
	private int quantity;
//	 Cấu hình liên kết
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	@ManyToOne
	@MapsId("cusId")
	@JoinColumn(name = "CUS_ID", nullable = false)
	private Customer customer;

}
