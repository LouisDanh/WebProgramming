package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 7347939252891773559L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR(20)")
	private String email;
	@Column(name = "PASSWORD", nullable = false, columnDefinition = "VARCHAR(20)")
	private String password;
	@Column(name = "BAN", nullable = false)
	private boolean ban;
	@Column(name = "ROLE", nullable = false)
	private int role;
	@Column(name = "CREATE_DATE", nullable = false)
	private LocalDateTime createDate;

//	 Cấu hình liên kết
	@OneToOne
	@JoinColumn(name = "CUS_ID")
	private Customer customer;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUS_ID")
	private List<Violate> violates;

	public Account() {

	}

	public Account(String email, String password, Customer customer) {
		ban = false;
		createDate = LocalDateTime.now();
		this.email = email;
		this.password = password;
		this.customer = customer;
	}

}
