package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ProductBenenfitId implements Serializable{
	private static final long serialVersionUID = 6667213580579184358L;
	private int productId;
	private int purposeId;

	@Override
	public int hashCode() {
		return Objects.hash(productId, purposeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBenenfitId other = (ProductBenenfitId) obj;
		return productId == other.productId && purposeId == other.purposeId;
	}
}
