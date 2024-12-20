package models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PURPOSE")
public class Purpose implements Serializable {
	private static final long serialVersionUID = -2000061415947397510L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DESCRIPTION")
	private String decription;
	@Column(name = "ACTIVE")
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "PURPOSE_TYPE_ID")
	private PurposeType type;
	@ManyToMany
	@JoinTable(name = "PRODUCT_BENEFIT", joinColumns = @JoinColumn(referencedColumnName = "PURPOSE_ID"), inverseJoinColumns = @JoinColumn(referencedColumnName = "PRODUCT_ID"))
	private List<Product> products;

	public Purpose() {
		active = true;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public PurposeType getType() {
		return type;
	}

	public void setType(PurposeType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		Purpose other = (Purpose) obj;
		return id == other.id;
	}

}
