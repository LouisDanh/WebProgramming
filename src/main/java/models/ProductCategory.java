package models;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 9215015874801278028L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	@Nationalized
	private String name;
	@Column(name = "DESCRIPTION")
	@Nationalized
	private String description;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Product> products;
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private ProductCategory parent;
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<ProductCategory> children;

	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	public int getSize() {
		return this.children.size();
	}

	public List<ProductCategory> getChildren() {
		return children;
	}

	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String decription) {
		this.description = decription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
		ProductCategory other = (ProductCategory) obj;
		return id == other.id;
	}

	public boolean isSameCategory(int categoryId) {
		for (ProductCategory productCategory : children) {
			if (productCategory.isSameCategory(categoryId))
				return true;
		}
		return false;
	}

	public Integer getId() {
		return id;
	}

}
