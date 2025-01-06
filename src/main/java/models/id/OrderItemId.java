package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItemId implements Serializable {
	private static final long serialVersionUID = 8933858995194121739L;
	private Integer detailId;
	private Integer productId;

	@Override
	public int hashCode() {
		return Objects.hash(detailId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return detailId == other.detailId && productId == other.productId;
	}
}
