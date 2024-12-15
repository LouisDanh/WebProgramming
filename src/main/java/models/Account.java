package models;

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
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ, vui lòng kiểm tra!")
	@Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR(20)")
	private String email;
	@NotBlank(message = "Password không được để trống")
	@Column(name = "PASSWORD", nullable = false, columnDefinition = "VARCHAR(20)")
	private String password;
	@Column(name = "BAN")
	private boolean ban;
	@Column(name = "ROLE")
	private int role;
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	
//	 Cấu hình liên kết
	@OneToOne
	@JoinColumn(name = "CUS_ID")
	private Customer customer;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="CUS_ID")
	private List<Violate> violates;

	public Account() {
		ban = false;
		createDate = LocalDateTime.now();
	}
}
