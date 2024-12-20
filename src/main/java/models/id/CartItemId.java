package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CartItemId implements Serializable{
	private static final long serialVersionUID = -746659657905733951L;
	private int cusId;
	private int productId;
	@Override
	public int hashCode() {
		return Objects.hash(cusId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemId other = (CartItemId) obj;
		return cusId == other.cusId && productId == other.productId;
	}
	

}
