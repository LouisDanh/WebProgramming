package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1031983419707490573L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Nationalized
	@Column(name = "ACCOUNT_NO", nullable = false)
	private Long noAccount;
	@Column(name = "BALANCE", nullable = false)
	private Double balance;
//	 Cấu hình liên kết
	@Column(name = "BANK_ID", nullable = false)
	private Integer bankId;
	@Nationalized
	@Column(name = "BANK_NAME", nullable = false)
	private String bankName;
}
