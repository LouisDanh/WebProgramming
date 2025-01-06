package models;

import java.io.Serializable;
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
public class OrderDate implements Serializable{
	private static final long serialVersionUID = -8948402251618130891L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "DATE",nullable = false)
	private LocalDateTime date;
//	 Cấu hình liên kết
	@ManyToOne
	@JoinColumn(name = "STATE_ID", nullable = false)
	private OrderState orderState;

}
