package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ATTRIBUTES")
public class ProductAttributes implements Serializable {
	private static final long serialVersionUID = 3298580693096254172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "ATTRIBUTE_KEY_ID", nullable = false)
	private AttributeKey attributeKey;
	@ManyToOne
	@JoinColumn(name = "ATTRIBUTE_VALUE_ID", nullable = false)
	private AttributeValue value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AttributeKey getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(AttributeKey attributeKey) {
		this.attributeKey = attributeKey;
	}

	public String getValue() {
		return value.getValue();
	}

	public AttributeValue getAttValue() {
		return value;
	}

	public ProductAttributes() {
	}

	public ProductAttributes(AttributeKey attributeKey, AttributeValue value) {
		this.attributeKey = attributeKey;
		this.value = value;
	}
}
