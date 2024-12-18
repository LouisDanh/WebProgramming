package models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VIOLATE")
public class Violate implements Serializable{
	private static final long serialVersionUID = -8425557510713408881L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DESCRIPTION", columnDefinition = "varchar(100)")
	private String description;
	@Column(name = "DATE")
	private LocalDateTime date;
}
