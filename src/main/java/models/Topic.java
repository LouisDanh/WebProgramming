package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
@Table(name = "TOPIC")
public class Topic implements Serializable {
	private static final long serialVersionUID = -3425253960930818716L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private List<ProductTopic> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * Lấy danh sách ProductType kèm với Product
	 * 
	 * @return map dữ liệu
	 */
	public Map<ProductType, List<Product>> getProducts() {
		Map<ProductType, List<Product>> result = new HashMap<ProductType, List<Product>>();
		for (ProductTopic productTopic : products) {
			List<Product> products = result.get(productTopic.getProductType());
			if (products == null) {
				products = new LinkedList<Product>();
				result.put(productTopic.getProductType(), products);
			}
			products.add(productTopic.getProduct());
		}
		return result;
	}

}
