package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TOPIC")
public class ProductTopic {
	@EmbeddedId
	private ProductTopicId id;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	@ManyToOne
	@MapsId("productTypeId")
	@JoinColumn(name = "PURPOSE_TYPE_ID", nullable = false)
	private ProductType productType;
}
