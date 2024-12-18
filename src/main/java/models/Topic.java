package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="TOPIC")
public class Topic implements Serializable{
	private static final long serialVersionUID = -3425253960930818716L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="TITLE",columnDefinition = "varchar(30)")
	private String title;
	@Column(name = "DESCRIPTION",columnDefinition = "varchar(50)")
	private String description;
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private List<ProductTopic> products;
}
