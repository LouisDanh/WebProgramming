package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TopicProductId implements Serializable {
	private static final long serialVersionUID = -8976024609803431246L;
	private Integer topicId;
	private Integer productId;

	@Override
	public int hashCode() {
		return Objects.hash(topicId, productId);
	}

}
