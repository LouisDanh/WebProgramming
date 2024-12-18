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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable{
	private static final long serialVersionUID = -8145256353326935319L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TOTAL_AMOUNT",nullable = false)
	private double totalAmount;
//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="INVOICE_ID")
	private List<Order> orders;
	
	
}
