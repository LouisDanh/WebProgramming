package models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import models.id.VoucherStateId;

@Entity
@Table(name = "VOUCHER_STATE")
public class VoucherState implements Serializable {
	private static final long serialVersionUID = -1070809452707047256L;

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
