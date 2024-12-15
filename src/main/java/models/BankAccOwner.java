package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity	
@Table(name = "BANK_ACC_OWNER")
public class BankAccOwner {
	@EmbeddedId
	private BankAccOwnerId id;
	@ManyToOne
	@MapsId("bankAccountId")
	@JoinColumn(name = "BANK_ACCOUNT_ID", nullable = false)
	private BankAccount bankAccount;
	@ManyToOne
	@MapsId("cusId")
	@JoinColumn(name = "CUS_ID", nullable = false)
	private Customer customer;

}
