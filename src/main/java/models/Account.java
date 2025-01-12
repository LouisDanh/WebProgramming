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

import utils.AccountUtil;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 7347939252891773559L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "BAN", nullable = false)
	private Boolean ban;
	@Column(name = "ROLE", nullable = false)
	private Integer role;
	@Column(name = "CREATE_DATE", nullable = false)
	private LocalDateTime createDate;

//	 Cấu hình liên kết
	@OneToOne
	@JoinColumn(name = "CUS_ID")
	private Customer customer;
	public Account() {
		createDate = LocalDateTime.now();
		ban = false;
	}
	public Account(String email, String password, Customer customer) {
		ban = false;
		createDate = LocalDateTime.now();
		this.email = email;
		this.password = password;
		this.customer = customer;
		role=5;
	}
	

	public Boolean getBan() {
		return ban;
	}

	public void setBan(Boolean ban) {
		this.ban = ban;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean checkPassword(Integer accountId, String currentPassword) {
	    if (this.id.equals(accountId)) {
	        return this.password.equals(currentPassword);
//	        return AccountUtil.verifyPassword(currentPassword, this.password); 
	    }
	    return false;
	}

}
