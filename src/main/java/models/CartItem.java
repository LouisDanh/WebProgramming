package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import models.id.CartItemId;

@Entity
@Table(name = "CART_ITEM")
public class CartItem implements Serializable {
	private static final long serialVersionUID = -4132663281121554799L;
	@EmbeddedId
	private CartItemId id;
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;
//	 Cấu hình liên kết
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	@ManyToOne
	@MapsId("cusId")
	@JoinColumn(name = "CUS_ID", nullable = false)
	private Customer customer;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the id
	 */
	public CartItemId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CartItemId id) {
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
