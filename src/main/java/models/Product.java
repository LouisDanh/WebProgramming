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

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = -864055505260462770L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", columnDefinition = "varchar(30)")
	private String name;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "DISCOUNT", columnDefinition = "DECIMAL(5,2)")
	private double discount;
	@Column(name = "STOCK", nullable = false)
	private int stock;
	@Column(name = "CAPACITY", nullable = false)
	private int capacity;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private List<Gallery> galleries;
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private ProductType type;
	@ManyToOne
	@JoinColumn(name = "BRAND")
	private Brand brand;

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

	public boolean inPurposeType(int idType) {
		return type.getId() == idType;
	}

}
