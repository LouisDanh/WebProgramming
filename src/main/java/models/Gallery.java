package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "GALLERY")
public class Gallery implements Serializable {
	public static final String IMG = "IMGAGE";
	public static final String VIDEO = "VIDEO";
	private static final long serialVersionUID = -7810072010082294351L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Nationalized
	@Column(name = "TYPE", nullable = false)
	private String type;
	@Column(name = "LINK", nullable = false)
	private String link;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
