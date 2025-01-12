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
	@Column(name= "CODE",nullable = false)
	private String code;
	/**
	 * @return the maxDiscount
	 */
	public Double getMaxDiscount() {
		return maxDiscount;
	}
	/**
	 * @param maxDiscount the maxDiscount to set
	 */
	public void setMaxDiscount(Double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the percentage
	 */
	public Double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the expiredDate
	 */
	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}
	/**
	 * @param expiredDate the expiredDate to set
	 */
	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}
}
