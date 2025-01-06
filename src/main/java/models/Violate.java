package models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "VIOLATE")
public class Violate implements Serializable{
	private static final long serialVersionUID = -8425557510713408881L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name = "DESCRIPTION")
	@Nationalized
	private String description;
	@Column(name = "DATE")
	private LocalDateTime date;
}
