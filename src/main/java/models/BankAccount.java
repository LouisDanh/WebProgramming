package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable{
	private static final long serialVersionUID = 1031983419707490573L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ACCOUNT_NO",nullable = false)
	private long noAccount;
	@Column(name = "BALANCE",nullable = false)
	private double balance;
//	 Cấu hình liên kết
	@ManyToOne
	@JoinColumn(name = "BANK_ID", nullable = false)
	private Bank bank;
}
