package models;

public class CashPayment implements PaymentMethodStategy {
	private PaymentMethod method;
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public double pay() {
		return 0;
	}

}
