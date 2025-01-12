package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "VOUCHER")
public class Voucher implements Serializable{
	private static final long serialVersionUID = -1870479247193352102L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "NAME", nullable = false)
	@Nationalized
	private String name;
	@Column(name = "PERCENTAGE",nullable = false)
	private Double percentage;
	@Column(name = "MAX_DISCOUNT",nullable = false)
	private Double maxDiscount;
	@Column(name = "EXPIRED_DATE",nullable = false)
	private LocalDateTime expiredDate;
	@Column(name = "QUANTITY",nullable = false)
	private Integer quantity;
}
