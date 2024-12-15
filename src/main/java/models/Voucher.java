package models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VOUCHER")
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", columnDefinition = "varchar(20)",nullable = false)
	private String name;
	@Column(name = "PERCENTAGE",nullable = false)
	private double percentage;
	@Column(name = "MAX_DISCOUNT",nullable = false)
	private double maxDiscount;
	@Column(name = "EXPIRED_DATE",nullable = false)
	private LocalDateTime expiredDate;
	@Column(name = "QUANTITY",nullable = false)
	private int quantity;
	@OneToMany(mappedBy = "voucher")
	private List<VoucherState> state;

}
