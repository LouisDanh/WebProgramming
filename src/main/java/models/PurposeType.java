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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PURPOSE_TYPE")
public class PurposeType implements Serializable{
	private static final long serialVersionUID = 8348650813428879371L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME",columnDefinition = "varchar(30)")
	private String name;
	@Column(name="ACTIVE")
	private boolean active;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="PURPOSE_TYPE_ID")
	private List<Purpose> purposes;
	public PurposeType() {
		active=true;
	}
}
