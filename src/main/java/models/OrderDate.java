package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ORDER_DATE")
public class OrderDate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DATE",nullable = false)
	private LocalDateTime date;
//	 Cấu hình liên kết
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private OrderState orderState;

}
