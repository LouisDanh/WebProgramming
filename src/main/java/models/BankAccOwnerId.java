package models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BankAccOwnerId implements Serializable{
	private static final long serialVersionUID = 2680491701495028602L;
	private int cusId;
	private int bankAccountId;
	@Override
	public int hashCode() {
		return Objects.hash(bankAccountId, cusId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccOwnerId other = (BankAccOwnerId) obj;
		return bankAccountId == other.bankAccountId && cusId == other.cusId;
	}
	
}	
