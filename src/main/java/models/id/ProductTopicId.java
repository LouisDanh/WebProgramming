package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ProductTopicId implements Serializable {
	private static final long serialVersionUID = -7723429605739692746L;
	private int productId;
	private int productTypeId;

	@Override
	public int hashCode() {
		return Objects.hash(productId, productTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductTopicId other = (ProductTopicId) obj;
		return productId == other.productId && productTypeId == other.productTypeId;
	}
}
