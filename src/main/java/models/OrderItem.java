package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import models.id.OrderItemId;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 5144383351715767229L;

	@EmbeddedId
	private OrderItemId id;
	
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;
	@Column(name="RATING")
	private Integer rating;
//	 Cấu hình liên kết
	@ManyToOne()
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID",nullable = false)
	private Product product;
	@ManyToOne()
	@MapsId("detailId")
	@JoinColumn(name = "DETAIL_ID",nullable = false)
	private OrderDetails detail;
	/**
	 * @return the id
	 */
	public OrderItemId getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(OrderItemId id) {
		this.id = id;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the detail
	 */
	public OrderDetails getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(OrderDetails detail) {
		this.detail = detail;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
