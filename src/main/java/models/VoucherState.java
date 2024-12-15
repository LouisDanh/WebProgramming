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
@Table(name = "VOUCHER_STATE")
public class VoucherState {
	@EmbeddedId
	private VoucherStateId id;
	
	@ManyToOne
	@MapsId("cusId")
	@JoinColumn(name = "CUS_ID", nullable = false)
	private Customer customer;
	@ManyToOne
	@MapsId("voucherId")
	@JoinColumn(name = "VOUCHER_ID", nullable = false)
	private Voucher voucher;
}
