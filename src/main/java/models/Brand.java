package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BRAND")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", columnDefinition = "varchar(20)", nullable = false)
	private String name;
	@Column(name = "ACTIVE")
	private boolean active;
//	 Cấu hình liên kết
	@OneToMany
	@JoinColumn(name = "BAND_ID")
	private List<Product> products;

	public Brand() {
		active = true;
	}

}
