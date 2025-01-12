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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = -864055505260462770L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Nationalized
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "DISCOUNT", columnDefinition = "DECIMAL(5,2)")
	private Double discount;
	@Column(name = "STOCK", nullable = false)
	private Integer stock;
	@Column(name = "CAPACITY", nullable = false)
	private Integer capacity;
	@Nationalized
	@Column(name = "DESCRIPTION")
	private String description;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private List<Gallery> galleries;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private ProductCategory category;
	@ManyToOne
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
	private List<ProductAttributes> attributes;

	public List<ProductAttributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ProductAttributes> attributes) {
		this.attributes = attributes;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Gallery> getGalleries() {
		return galleries;
	}

	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSameCategory(int categoryId) {
		return this.category.isSameCategory(categoryId);
	}

}
