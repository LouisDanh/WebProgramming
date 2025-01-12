package models;

import java.io.Serializable;
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

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = -7422323496908434761L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Nationalized
	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;
	@Column(name = "PLACE_RECEIVE")
	@Nationalized
	private String placeReceive;
	@Column(name = "PHONE", nullable = false)
	private String phone;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BANK_ACC_OWNER", joinColumns = @JoinColumn(name = "CUS_ID"), inverseJoinColumns = @JoinColumn(name = "BANK_ACCOUNT_ID"))
	private List<BankAccount> listBankAccount;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUS_ID", nullable = false)
	private List<Orders> historyOrder;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CartItem> carts;
	@ManyToMany
	@JoinTable(name = "VOUCHER_STATE", joinColumns = @JoinColumn(name = "CUS_ID"), inverseJoinColumns = @JoinColumn(name = "VOUCHER_ID"))
	private List<Voucher> voucherUsed;

	public Customer(String fullName, String phone) {
		this.fullName = fullName;
		this.phone = phone;
	}

	public Customer() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getPlaceReceive() {
		return placeReceive;
	}

	public void setPlaceReceive(String placeReceive) {
		this.placeReceive = placeReceive;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<BankAccount> getListBankAccount() {
		return listBankAccount;
	}

	public void setListBankAccount(List<BankAccount> listBankAccount) {
		this.listBankAccount = listBankAccount;
	}

	public List<Orders> getHistoryOrder() {
		return historyOrder;
	}

	public void setHistoryOrder(List<Orders> historyOrder) {
		this.historyOrder = historyOrder;
	}

	public List<CartItem> getCarts() {
		return carts;
	}

	public void setCarts(List<CartItem> carts) {
		this.carts = carts;
	}

}
