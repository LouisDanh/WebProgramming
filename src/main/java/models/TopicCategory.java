package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import models.id.TopicCategoryId;

@Entity
@Table(name = "TOPIC_CATEGORY")
public class TopicCategory {
	@EmbeddedId
	private TopicCategoryId id;
	@ManyToOne
	@MapsId("categoryId")
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private ProductCategory category;
	@ManyToOne
	@MapsId("topicId")
	@JoinColumn(name = "TOPIC_ID", nullable = false)
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
