package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank implements Serializable{
	private static final long serialVersionUID = -2711264067848552006L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(20)")
	private String name;
	@Column(name = "ACTIVE",nullable = false)
	private boolean active;
//	 Cấu hình liên kết
	@OneToMany(mappedBy = "bank")
	private List<BankAccount> bankAccounts;
	public Bank() {
		active=true;
	}
	public Bank( String name) {
		this();
		this.name = name;
	}
}
