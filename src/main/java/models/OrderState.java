package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_STATE")
public class OrderState implements Serializable{
	private static final long serialVersionUID = 1649218980012095021L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DECRIPTION", columnDefinition = "varchar(200)",nullable = false)
	private String description;
}
