package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODCUT")
public class Product {
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
	@Column(name = "ACTIVE")
	private boolean active;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private List<Gallery> galleries;

	public Product() {
		active = true;
	}
}
