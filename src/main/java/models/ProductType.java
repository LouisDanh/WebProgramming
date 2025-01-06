package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 9215015874801278028L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "NAME")
	@Nationalized
	private String name;
	@Column(name = "DECRIPTION")
	@Nationalized
	private String decription;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	private List<Product> products;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PURPOSE_ID")
	private List<Purpose> purposes;
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private ProductType parent;
	@OneToMany(mappedBy = "parent")
	private List<ProductType> children;
	
	// lưu dữ liệu mapping PurposeType-> list Purpose, Purpose-> list
	// Product
	private static Map<PurposeType, Map<Purpose, List<Product>>> mappingPP;
	// Lưu dữ liệu mapping Brand -> list product;
	private static Map<Brand, List<Product>> mappingBP;

	/**
	 * Lấy dữ liệu mapping PurposeType-> list Purpose, Purpose-> list
	 * 
	 * @return map dữ liệu giữa purposeType và map (purpose với listProduct)
	 */
	public Map<PurposeType, Map<Purpose, List<Product>>> getPurposes() {
		if (mappingPP != null)
			return mappingPP;
		mappingPP = new HashMap<PurposeType, Map<Purpose, List<Product>>>();
		for (Purpose purpose : purposes) {
			Map<Purpose, List<Product>> mapPurpose = mappingPP.get(purpose.getType());
			if (mapPurpose == null) {
				mapPurpose = new HashMap<Purpose, List<Product>>();
				mappingPP.put(purpose.getType(), mapPurpose);
			}
			mapPurpose.put(purpose, purpose.getProducts().stream().filter(i -> i.inPurposeType(id)).toList());
		}
		return mappingPP;
	}

	/**
	 * Lấy dữ liệu mapping Brand-> list Product
	 * 
	 * @return map dữ liệu giữa brand và listProduct
	 */
	public Map<Brand, List<Product>> getBrands() {
		if (mappingBP != null)
			return mappingBP;
		mappingBP = new HashMap<Brand, List<Product>>();
		for (Product product : products) {
			List<Product> list = mappingBP.get(product.getBrand());
			if (list == null) {
				list = new LinkedList<Product>();
				mappingBP.put(product.getBrand(), list);
			}
			list.add(product);
		}
		return mappingBP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setPurposes(List<Purpose> purposes) {
		this.purposes = purposes;
	}

	public ProductType getParent() {
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProductType> getChildren() {
		return children;
	}

	public void setChildren(List<ProductType> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductType other = (ProductType) obj;
		return id == other.id;
	}

}
