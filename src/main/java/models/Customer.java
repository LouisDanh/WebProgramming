package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "FULL_NAME", columnDefinition = "varchar(50)",nullable = false)
	private String fullName;
	@Column(name = "PLACE_RECEIVE")
	private String placeReceive;
	@Column(name = "GENDER", columnDefinition = "varchar(10)",nullable = false)
	private String gender;
	@Column(name = "PHONE", columnDefinition = "varchar(10)",nullable = false)
	private String phone;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BANK_ACC_OWNER", joinColumns = @JoinColumn(name = "CUS_ID"), inverseJoinColumns = @JoinColumn(name = "BANK_ACCOUNT_ID"))
	private List<BankAccount> listBankAccount;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUS_ID",nullable = false)
	private List<Invoice> historyOrder;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CartItem> carts;
	@ManyToMany
	@JoinTable(name = "VOUCHER_STATE", joinColumns = @JoinColumn(name = "CUS_ID"), inverseJoinColumns = @JoinColumn(name = "VOUCHER_ID"))
	private List<Voucher> voucherUsed;
}
