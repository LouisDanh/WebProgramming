package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_METHOD")
public class PaymentMethod implements Serializable {
	private static final long serialVersionUID = 110252482276396261L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", columnDefinition = "varchar(20)")
	private String name;
	@Column(name = "DISCOUNT", columnDefinition = "decimal(5,2)")
	private double discount;
	/**
	 * convert to payment strategy class
	 */
	@Column(name = "STRATEGY_CLASS", columnDefinition = "varchar(50)")
	private String strategyClass;
	@Column(name = "ACTIVE")
	private boolean active;

	public PaymentMethod() {
		active = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrategyClass() {
		return strategyClass;
	}

	public void setStrategyClass(String stategyClass) {
		this.strategyClass = stategyClass;
	}
}
