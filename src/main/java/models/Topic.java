package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TOPIC")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Topic implements Serializable {
	private static final long serialVersionUID = -3425253960930818716L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	@OneToMany(mappedBy = "topic")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<TopicProduct> products;
	@OneToMany(mappedBy = "topic")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<TopicCategory> categories;
	@Transient
	private Map<TopicCategory, List<TopicProduct>> mappingProduct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@PostLoad
	private void loadMapping() {
		mappingProduct = new HashMap<TopicCategory, List<TopicProduct>>();
		for (TopicCategory topicCategory : categories) {
			List<TopicProduct> listProduct = new LinkedList<TopicProduct>();
			for (TopicProduct topicProduct : products) {
				if (topicProduct.isSameCategory(topicCategory.getIdCategory())) {
					listProduct.add(topicProduct);
				}
			}
			mappingProduct.put(topicCategory, listProduct);
		}
	}

	public List<TopicCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<TopicCategory> categories) {
		this.categories = categories;
	}

	public Map<TopicCategory, List<TopicProduct>> getMappingProduct() {
		return mappingProduct;
	}

	public void setMappingProduct(Map<TopicCategory, List<TopicProduct>> mappingProduct) {
		this.mappingProduct = mappingProduct;
	}

}
