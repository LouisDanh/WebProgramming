package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import models.id.TopicProductId;

@Entity
@Table(name = "TOPIC_PRODUCT")
public class TopicProduct implements Serializable {
	private static final long serialVersionUID = -7355520214514616153L;
	@EmbeddedId
	private TopicProductId id;
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	@ManyToOne
	@MapsId("topicId")
	@JoinColumn(name = "TOPIC_ID", nullable = false)
	private Topic topic;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
