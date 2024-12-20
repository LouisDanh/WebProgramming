package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class VoucherStateId implements Serializable {
	private static final long serialVersionUID = -7893920505554652675L;
	private int voucherId;
	private int cusId;

	@Override
	public int hashCode() {
		return Objects.hash(cusId, voucherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoucherStateId other = (VoucherStateId) obj;
		return cusId == other.cusId && voucherId == other.voucherId;
	}

}
