package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PURPOSE")
public class Purpose implements Serializable{
	private static final long serialVersionUID = -2000061415947397510L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DESCRIPTION")
	private String decription;
	@Column(name = "ACTIVE")
	private boolean active;
	public Purpose() {
		active = true;
	}
}
