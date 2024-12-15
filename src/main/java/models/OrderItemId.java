package models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItemId implements Serializable {
	private int orderId;
	private int productId;

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
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
		return orderId == other.orderId && productId == other.productId;
	}
}
