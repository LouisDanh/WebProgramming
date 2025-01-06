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

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "PURPOSE")
public class Purpose implements Serializable {
	private static final long serialVersionUID = -2000061415947397510L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "DESCRIPTION")
	@Nationalized
	private String decription;
	@ManyToOne
	@JoinColumn(name = "PURPOSE_TYPE_ID")
	private PurposeType type;
	@ManyToMany
	@JoinTable(name = "PRODUCT_BENEFIT", 
		    joinColumns = @JoinColumn(name = "PURPOSE_ID"), 
		    inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Product> products;

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
